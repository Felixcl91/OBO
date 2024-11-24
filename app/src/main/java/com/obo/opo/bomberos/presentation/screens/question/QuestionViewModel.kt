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
import com.obo.opo.bomberos.domain.useCase.auth.AuthUseCase
import com.obo.opo.bomberos.domain.useCase.questions.QuestionsUseCase
import com.obo.opo.bomberos.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val questionsUseCase: QuestionsUseCase,
    private val authUseCase: AuthUseCase
) : ViewModel() {

    var errorMessage by mutableStateOf("")

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
        authUseCase.getSessionData().collect() { data ->
            if (!data.token.isNullOrBlank()) {
                Log.d("QuestionViewModel", "Data Token Response: ${data.token}")
                questionsUseCase.getQuestionsUseCase(data.token).collect() {
                    questionsResponse = it
                    Log.d("QuestionViewModel", "DATA: $questionsResponse")
                }
            } else {
                Log.d("QuestionViewModel", "Data Token Error: ${data.token}")
            }
        }
    }

    // function with id THEME
    fun findByTheme() = viewModelScope.launch {
        questionsResponse = Resource.Loading // loading
        authUseCase.getSessionData().collect() { data ->
            if (!data.token.isNullOrBlank()) {
                Log.d("QuestionViewModel", "Data Token Response: ${data.token}")
                questionsUseCase.findByThemeUseCase(data.token, theme.id!!).collect() { // SUCCESS

                    if ((it as Resource.Success).data.isEmpty()) {
                        Log.d("QuestionViewModel", "DATA FIND EMPTY: $questionsResponse")
                        questionsResponse = Resource.Failure("Este tema no tiene preguntas disponibles")
                    } else {
                        questionsResponse = it
                        questionsResponse as Resource.Success
                        Log.d("QuestionViewModel", "DATA FIND: $questionsResponse")
                    }

                }
            } else {
                Log.d("QuestionViewModel", "Data Token Error: ${data.token}")
            }
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

    // PREGUNTA ANTERIOR
    fun onBackQuestion() {
        if (currentIndex > 0) {
            currentIndex --
        }
    }

    //PREGUNTA ACTUAL
    fun currentQuestion(): Question? {

        return if (questionsResponse is Resource.Success) {
            (questionsResponse as Resource.Success).data[currentIndex]
        } else null
    }

    fun countQuestions(): Int {

        return (questionsResponse as Resource.Success).data.count()

    }

}

