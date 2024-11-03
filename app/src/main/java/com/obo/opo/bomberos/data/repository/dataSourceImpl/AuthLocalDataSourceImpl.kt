package com.obo.opo.bomberos.data.repository.dataSourceImpl

import com.obo.opo.bomberos.data.datastore.AuthDatastore
import com.obo.opo.bomberos.data.repository.dataSource.AuthLocalDataSource
import com.obo.opo.bomberos.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore): AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.saveUser(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()
}