package com.obo.opo.bomberos.data.repository

import com.obo.opo.bomberos.data.dataSource.remote.QuestionRemoteDataSource
import com.obo.opo.bomberos.domain.model.Question
import com.obo.opo.bomberos.domain.repository.QuestionRepository
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.util.ResponseToRequest
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class QuestionRepositoryImpl(private val questionRemoteDataSource: QuestionRemoteDataSource): QuestionRepository {

    override fun getQuestions(): Flow<Resource<List<Question>>> = callbackFlow {
        trySend(ResponseToRequest.send(questionRemoteDataSource.findAll()))
        awaitClose {
            cancel()
        }
    }

    override fun findByTheme(idTheme: String): Flow<Resource<List<Question>>> = flow {
        emit(ResponseToRequest.send(
            questionRemoteDataSource.findByTheme(idTheme)
        ))
    }
}