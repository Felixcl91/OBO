package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.data.dataSource.remote.service.QuestionService
import com.obo.opo.bomberos.domain.model.Question
import retrofit2.Response

class QuestionsRemoteDataSourceImpl(private val questionService: QuestionService):
    QuestionRemoteDataSource {

    override suspend fun findAll(): Response<List<Question>> = questionService.getQuestions(
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NSwibmFtZSI6IkNhdGFwbGFzbWEiLCJpYXQiOjE3MjkwOTE1ODYsImV4cCI6MTczMTY4MzU4Nn0.gw17GpHz_ZT8GnsiTfnc2F1VsQ1hTQ-4R63VJUl2ApA"
    )
    override suspend fun findByTheme(idTheme: String): Response<List<Question>> = questionService.findByTheme(
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NSwibmFtZSI6IkNhdGFwbGFzbWEiLCJpYXQiOjE3MjkwOTE1ODYsImV4cCI6MTczMTY4MzU4Nn0.gw17GpHz_ZT8GnsiTfnc2F1VsQ1hTQ-4R63VJUl2ApA",
        idTheme

    )
}