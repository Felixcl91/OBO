package com.obo.opo.bomberos.domain.useCase.auth

import com.obo.opo.bomberos.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}