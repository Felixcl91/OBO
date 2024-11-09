package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.data.dataSource.remote.service.AuthService
import com.obo.opo.bomberos.domain.model.AuthResponse
import com.obo.opo.bomberos.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private  val authService: AuthService): AuthRemoteDataSource {

    // REMOTE
    override suspend fun login(email: String, password: String) = authService.login(email, password)

    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)
}