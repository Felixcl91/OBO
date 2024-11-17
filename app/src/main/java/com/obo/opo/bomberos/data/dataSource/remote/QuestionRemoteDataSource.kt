package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.domain.model.Question
import retrofit2.Response

interface QuestionRemoteDataSource {

    suspend fun findAll(token: String): Response<List<Question>>

    suspend fun findByTheme(token: String, idTheme: String): Response<List<Question>>
}