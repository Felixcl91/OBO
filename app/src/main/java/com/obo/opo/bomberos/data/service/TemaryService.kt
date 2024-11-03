package com.obo.opo.bomberos.data.service

import com.obo.opo.bomberos.domain.model.Temary
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TemaryService {

    // http://192.168.119.214:3000/temaries
    // asincrono
    @GET("temaries")
    suspend fun getTemaries(
        @Header("Authorization") token: String
    ): Response<List<Temary>>
}