package com.obo.opo.bomberos.presentation.screens.temary.list

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obo.opo.bomberos.domain.model.Temary
import com.obo.opo.bomberos.domain.useCase.auth.AuthUseCase
import com.obo.opo.bomberos.domain.useCase.temaries.TemariesUseCase
import com.obo.opo.bomberos.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemaryViewModel
@Inject constructor(
    private val temariesUseCase: TemariesUseCase,
    private val authUseCase: AuthUseCase
) : ViewModel() {

    var temariesResponse by mutableStateOf<Resource<List<Temary>>?>(null)
        private set

    init {
        getTemaries()
    }

    fun getTemaries() = viewModelScope.launch {
        temariesResponse = Resource.Loading
        authUseCase.getSessionData().collect() {data ->
            if (!data.token.isNullOrBlank()) {
                Log.d("TemaryViewModel", "Data Token Response: ${data.token}")
                temariesUseCase.getTemaries(data.token).collect() { temaries ->
                    Log.d("TemaryViewModel", "Data temary: ${temaries}")
                    temariesResponse = temaries
                }
            } else {
                Log.d("TemaryViewModel", "Data Token Error: ${data.token}")
            }
        }
    }
}