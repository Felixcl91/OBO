package com.obo.opo.bomberos.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obo.opo.bomberos.domain.model.AuthResponse
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    // LOGIN RESPONSE
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        //getSessionData()
    }

    // LLAMAMOS A ESTA FUNCION CUANDO EL LOGINVIEWMODEL SEA INVOCADO
    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() {data ->
            if (!data.token.isNullOrBlank()) {
                loginResponse = Resource.Success(data)
            } else {
                Log.d("LoginViewModel", "Data NULL ${data}")
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()) {
            loginResponse = Resource.Loading // ESPERANDO
            val result = authUseCase.login(state.email, state.password) //RETORNA RESP
            loginResponse = result // EXITOSA / ERROR
            Log.d("LoginViewModel", "Response: ${loginResponse.toString()}")
        } else {
            Log.d("LoginViewModel", "Response Error: ${loginResponse.toString()}")
        }

    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    // asincrono
    fun isValidForm(): Boolean {

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        return true
    }
}