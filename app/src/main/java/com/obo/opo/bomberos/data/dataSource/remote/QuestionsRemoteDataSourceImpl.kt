package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.data.dataSource.remote.service.QuestionService
import com.obo.opo.bomberos.domain.model.Question
import retrofit2.Response

class QuestionsRemoteDataSourceImpl(private val questionService: QuestionService):
    QuestionRemoteDataSource {

    override suspend fun findAll(token: String): Response<List<Question>> =
        questionService.getQuestions(token)
    override suspend fun findByTheme(token: String, idTheme: String): Response<List<Question>> =
        questionService.findByTheme(token, idTheme)
}