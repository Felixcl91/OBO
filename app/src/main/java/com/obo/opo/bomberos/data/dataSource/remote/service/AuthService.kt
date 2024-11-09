package com.obo.opo.bomberos.data.dataSource.remote.service

import com.obo.opo.bomberos.domain.model.AuthResponse
import com.obo.opo.bomberos.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    // http://192.168.119.214:3000/auth/login
    // asincrono
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>

    // http://192.168.119.214:3000/auth/login
    // asincrono
    @POST("auth/register")
    suspend fun register(
        @Body() user: User
    ): Response<AuthResponse>


}