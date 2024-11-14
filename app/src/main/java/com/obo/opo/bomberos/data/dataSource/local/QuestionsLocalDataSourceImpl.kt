package com.obo.opo.bomberos.data.dataSource.local

import com.obo.opo.bomberos.data.dataSource.local.dao.QuestionDao
import com.obo.opo.bomberos.data.dataSource.local.entity.QuestionEntity
import kotlinx.coroutines.flow.Flow

class QuestionsLocalDataSourceImpl(private val questionDao: QuestionDao): QuestionsLocalDataSource {

    override suspend fun create(question: QuestionEntity) = questionDao.insert(question)

    override suspend fun insertAll(questions: List<QuestionEntity>) = questionDao.insertAll(questions)

    override fun getQuestions(): Flow<List<QuestionEntity>> = questionDao.getQuestions()

    override fun getQuestionsById(idTheme: String): Flow<List<QuestionEntity>> = questionDao.getQuestionsById(idTheme)
}