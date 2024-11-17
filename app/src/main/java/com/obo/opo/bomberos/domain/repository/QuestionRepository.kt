package com.obo.opo.bomberos.domain.repository

import com.obo.opo.bomberos.domain.model.Question
import com.obo.opo.bomberos.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {

    fun getQuestions(token: String): Flow<Resource<List<Question>>>

    fun findByTheme(token: String, idTheme: String): Flow<Resource<List<Question>>>
}