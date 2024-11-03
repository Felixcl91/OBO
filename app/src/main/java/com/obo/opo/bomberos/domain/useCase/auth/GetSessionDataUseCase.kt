package com.obo.opo.bomberos.domain.useCase.auth

import com.obo.opo.bomberos.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.getSessionData()
}