package com.obo.opo.bomberos.data.repository.dataSource

import com.obo.opo.bomberos.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    fun getSessionData(): Flow<AuthResponse>
}