package com.obo.opo.bomberos.presentation.screens.question

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.text.HtmlCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obo.opo.bomberos.domain.model.Question
import com.obo.opo.bomberos.domain.model.Theme
import com.obo.opo.bomberos.domain.useCase.questions.QuestionsUseCase
import com.obo.opo.bomberos.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val questionsUseCase: QuestionsUseCase
) : ViewModel() {

    // theme
    var data = savedStateHandle.get<String>("theme")
    var theme = Theme.fromJson(data!!)

    // questions
    private val _questions = MutableLiveData<Resource<List<Question>>>()
    val questions: LiveData<Resource<List<Question>>> get() = _questions

    // Response question
    var questionsResponse by mutableStateOf<Resource<List<Question>>?>(null)
        private set

    // Incializate Questions position 0
    private var currentIndex by mutableStateOf(0)

    init {
        //getQuestions()
        findByTheme()
    }

    // function without id THEME
    fun getQuestions() = viewModelScope.launch {
        questionsResponse = Resource.Loading
        questionsUseCase.getQuestionsUseCase().collect() {
            questionsResponse = it
            Log.d("QuestionViewModel", "DATA: $questionsResponse")
        }
    }

    // function with id THEME
    fun findByTheme() = viewModelScope.launch {
        questionsResponse = Resource.Loading // loading
        questionsUseCase.findByThemeUseCase(theme.id!!).collect() { // SUCCESS
            questionsResponse = it
            Log.d("QuestionViewModel", "DATA SUCCES: $questionsResponse")
        }
    }

    // SIGUIENTE PREGUNTA
    fun nextQuestion() {
        if (questionsResponse is Resource.Success && currentIndex < (questionsResponse as Resource.Success).data.size - 1) {
            currentIndex++
        } else {
            // MOSTRAR TEXTO SI YA NO HAY MAS QUESTIONS
        }
    }

    //PREGUNTA ACTUAL
    fun currentQuestion(): Question? {

        return if (questionsResponse is Resource.Success) {

            (questionsResponse as Resource.Success).data[currentIndex]
        } else null
    }

}

