package com.obo.opo.bomberos.domain.repository

import com.obo.opo.bomberos.domain.model.AuthResponse
import com.obo.opo.bomberos.domain.model.User

import com.obo.opo.bomberos.domain.util.Resource
import kotlinx.coroutines.flow.Flow

//Metodos para la autenticación
interface AuthRepository {

    // suspend por las corrutinas y asincrono
    suspend fun login(email: String, password: String): Resource<AuthResponse>

    suspend fun register(user: User): Resource<AuthResponse>

    suspend fun saveSession(authResponse: AuthResponse)
    fun getSessionData(): Flow<AuthResponse>

}