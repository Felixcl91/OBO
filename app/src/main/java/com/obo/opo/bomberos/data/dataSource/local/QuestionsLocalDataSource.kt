package com.obo.opo.bomberos.data.dataSource.local

import com.obo.opo.bomberos.data.dataSource.local.entity.QuestionEntity
import kotlinx.coroutines.flow.Flow

interface QuestionsLocalDataSource {

    suspend fun create(question: QuestionEntity)
    suspend fun insertAll(questions: List<QuestionEntity>)
    fun getQuestions(): Flow<List<QuestionEntity>>
    fun getQuestionsById(idTheme: String): Flow<List<QuestionEntity>>
}