package com.obo.opo.bomberos.domain.useCase.auth

import com.obo.opo.bomberos.domain.model.AuthResponse
import com.obo.opo.bomberos.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}