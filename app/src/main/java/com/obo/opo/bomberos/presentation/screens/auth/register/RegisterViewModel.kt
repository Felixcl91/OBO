package com.obo.opo.bomberos.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obo.opo.bomberos.domain.model.AuthResponse
import com.obo.opo.bomberos.domain.model.User
import com.obo.opo.bomberos.domain.useCase.auth.AuthUseCase
import com.obo.opo.bomberos.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun register() = viewModelScope.launch {
        if (isValidForm()) {
            val user = User(
                name = state.name,
                lastname = state.lastname,
                phone = state.phone,
                email = state.email,
                password = state.password
            )
            registerResponse = Resource.Loading
            val result = authUseCase.register(user)
            registerResponse = result // DATA O ERROR
        }
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onLastnameInput(lastname: String) {
        state = state.copy(lastname = lastname)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPhoneInput(phone: String) {
        state = state.copy(phone = phone)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }

    // asincrono
    fun isValidForm() : Boolean {

        if (state.name == "") {
            errorMessage = "Por favor ingrese el nombre"
            return false
        }
        else if (state.lastname == "") {
            errorMessage = "Por favor ingrese los apellidos"
            return false
        }
        else if (state.email == "") {
            errorMessage = "Por favor ingrese el email"
            return false
        }
        else if (state.phone == "") {
            errorMessage = "Por favor ingrese el telefono"
            return false
        }
        else if (state.password == "") {
            errorMessage = "Por favor ingrese una contraseña"
            return false
        }
        else if (state.confirmPassword == "") {
            errorMessage = "Por favor confirme la contraseña"
            return false
        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        else if (state.password != state.confirmPassword) {
            errorMessage = "La contraseñas no coinciden"
            return false
        }

        return true
    }
}