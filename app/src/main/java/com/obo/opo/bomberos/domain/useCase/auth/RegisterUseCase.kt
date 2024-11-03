package com.obo.opo.bomberos.domain.useCase.auth

import com.obo.opo.bomberos.domain.model.User
import com.obo.opo.bomberos.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.register(user)
}