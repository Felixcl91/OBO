package com.obo.opo.bomberos.presentation.screens.question

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
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

    /** VARIABLES QUESTIONS DIVIDE **/
    private val _questionsPart1 = mutableStateOf<List<Question>>(emptyList())
    //val questionsPart1: State<List<Question>> = _questionsPart1

    private val _questionsPart2 = mutableStateOf<List<Question>>(emptyList())
    //val questionsPart2: State<List<Question>> = _questionsPart2
    //val questionsPart2: LiveData<Resource<List<Question>>?> = _questionsPart2

    // Preguntas actuales que se muestran
    private var _currentQuestions = mutableStateOf<List<Question>>(emptyList())
    val currentQuestions: List<Question> get() = _currentQuestions.value

    private val _currentPart = mutableStateOf(1) // 1 = Parte 1, 2 = Parte 2
    val currentPart: State<Int> = _currentPart


    private var _showParts = mutableStateOf(false) // Indica si mostrar botones de partes
    var showParts: State<Boolean> = _showParts

    //private val _currentQuestions = mutableStateOf<List<Question>>(emptyList())
    //val currentQuestions: State<List<Question>> = _currentQuestions


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

                    questionsResponse = it

                    //loadQuestions(it)

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

        /*return if (questionsResponse is Resource.Success) {
            currentQuestions[currentIndex]
        } else null*/

        return if (questionsResponse is Resource.Success) {
            (questionsResponse as Resource.Success).data[currentIndex]
        } else null
    }

    fun countQuestions(): Int {

        return (questionsResponse as Resource.Success).data.count()

    }

    private fun loadQuestions(resource: Resource<List<Question>>) {
        questionsResponse = resource
        if (resource is Resource.Success) {
            val allQuestions = resource.data
            if (allQuestions.size > 100) {
                _showParts.value = true
                val (part1, part2) = questionsUseCase.divideQuestionsUseCase(allQuestions)
                _questionsPart1.value = part1
                _questionsPart2.value = part2
                //_currentQuestions.value = part1
                Log.d("QuestionViewModel", "Preguntas parte 1 (${part1.count()}): $part1")
                Log.d("QuestionViewModel", "Preguntas parte 2 (${part2.count()}): $part2")
            } else {
                _currentQuestions.value = allQuestions
            }

        }
    }

    fun showPart(part: Int){
        //_currentQuestions.value = if (part == 1) _questionsPart1.value else _questionsPart2.value
        _currentPart.value = part
        Log.d("QuestionViewModel", "ESTOY EN LA PARTE: $part")
        if (part == 1) {
            _currentQuestions.value = _questionsPart1.value
        } else if (part == 2) {
            _currentQuestions.value = _questionsPart2.value
        }
        /**if (part == 1) {
            questionsResponse = (_questionsPart1.value as Resource.Success<*>).data as Resource<List<Question>>?
        } else if (part == 2) {
            questionsResponse = (_questionsPart2.value as Resource.Success<*>).data as Resource<List<Question>>?
        }*/
    }
}

