package com.obo.opo.bomberos.data.repository.dataSource

import com.obo.opo.bomberos.domain.model.AuthResponse
import com.obo.opo.bomberos.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<AuthResponse>

    suspend fun register(user: User): Response<AuthResponse>
}