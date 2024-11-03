package com.obo.opo.bomberos.data.repository

import com.obo.opo.bomberos.data.repository.dataSource.AuthLocalDataSource
import com.obo.opo.bomberos.data.repository.dataSource.AuthRemoteDataSource
import com.obo.opo.bomberos.domain.model.AuthResponse
import com.obo.opo.bomberos.domain.model.User
import com.obo.opo.bomberos.domain.repository.AuthRepository
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

// INYECCION DE DEPENDENCIAS EN EL CONSTRUCTOR
class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()


}