package com.obo.opo.bomberos.presentation.screens.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obo.opo.bomberos.domain.useCase.auth.AuthUseCase
import com.obo.opo.bomberos.presentation.navigation.screen.AuthScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val authUseCase: AuthUseCase)
    :  ViewModel() {

    // LiveData o StateFlow para controlar la navegación
    private val _isSplashCompleted = MutableLiveData(false)
    val isSplashCompleted: LiveData<Boolean> = _isSplashCompleted

    private val _navigateTo = MutableLiveData<String>()
    val navigateTo: LiveData<String> = _navigateTo

    init {
        viewModelScope.launch {
            delay(3000) // Espera 3 segundos
            authUseCase.getSessionData().collect() {data ->
                if (!data.token.isNullOrBlank()) {
                    // Go to Main
                    _navigateTo.value = AuthScreen.Temaries.route
                    Log.d("SplashViewModel", "Data ${data}")
                } else {
                    // Go to Login
                    _navigateTo.value = AuthScreen.Login.route
                    Log.d("SplashViewModel", "Data NULL ${data}")
                }
                _isSplashCompleted.value = true // Cambia el estado para indicar que el splash ha terminado
                //_isSplashActive.value = false // Finaliza el splash
            }
        }
    }
}