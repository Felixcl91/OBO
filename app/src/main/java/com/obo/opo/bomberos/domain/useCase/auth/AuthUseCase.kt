package com.obo.opo.bomberos.domain.useCase.auth

data class AuthUseCase(

    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase
)
