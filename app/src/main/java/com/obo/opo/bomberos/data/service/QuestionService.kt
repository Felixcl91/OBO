package com.obo.opo.bomberos.data.service

import com.obo.opo.bomberos.domain.model.Question
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface QuestionService {

    // http://192.168.119.214:3000/themes
    // asincrono
    @GET("questions")
    suspend fun getQuestions(
        @Header("Authorization") token: String
    ): Response<List<Question>>

    // http://192.168.179.214:3000/themes/block/{id_block}
    // asincrono
    @GET("questions/theme/{id_theme}")
    suspend fun findByTheme(
        @Header("Authorization") token: String,
        @Path("id_theme") idTheme: String
    ): Response<List<Question>>
}