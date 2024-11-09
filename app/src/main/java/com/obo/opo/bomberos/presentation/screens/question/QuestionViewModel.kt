package com.obo.opo.bomberos.presentation.screens.question

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    // Response question
    var questionsResponse by mutableStateOf<Resource<List<Question>>?>(null)
        private set

    // Incializate Questions position 0
    var currentIndex by mutableStateOf(0)

    // Variable updated
    private val _isLastQuestion = MutableLiveData(false)
    val isLastQuestion: LiveData<Boolean> get() = _isLastQuestion


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
            currentIndex += 1
            _isLastQuestion.value = currentIndex == (questionsResponse as Resource.Success).data.size - 1
        } else {

        }
    }

    //PREGUNTA ACTUAL
    fun currentQuestion(): Question? {

        return if (questionsResponse is Resource.Success) {

            (questionsResponse as Resource.Success).data[currentIndex]
        } else null
    }

}

