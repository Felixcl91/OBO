package com.obo.opo.bomberos.data.repository

import android.util.Log
import com.obo.opo.bomberos.data.dataSource.local.QuestionsLocalDataSource
import com.obo.opo.bomberos.data.dataSource.remote.QuestionRemoteDataSource
import com.obo.opo.bomberos.data.mapper.toQuestion
import com.obo.opo.bomberos.data.mapper.toQuestionEntity
import com.obo.opo.bomberos.domain.model.Question
import com.obo.opo.bomberos.domain.repository.QuestionRepository
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.util.ResponseToRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class QuestionRepositoryImpl(
    private val remoteDataSource: QuestionRemoteDataSource,
    private  val localDataSource: QuestionsLocalDataSource
): QuestionRepository {

    override fun getQuestions(token: String): Flow<Resource<List<Question>>> = callbackFlow {
        trySend(ResponseToRequest.send(remoteDataSource.findAll(token)))
        awaitClose {
            cancel()
        }
    }

    override fun findByTheme(token: String, idTheme: String): Flow<Resource<List<Question>>> = flow {

        localDataSource.getQuestionsById(idTheme).collect() {
            it.run {
                if (this.isNotEmpty()) {
                    Log.d("QuestionRepositoryImpl", "DATA Local: ${this}")
                    emit(Resource.Success(this.map { questionEntity -> questionEntity.toQuestion() }))
                } else {
                    ResponseToRequest.send(remoteDataSource.findByTheme(token, idTheme)).run {
                        when (this) {
                            is Resource.Success -> {
                                Log.d("QuestionRepositoryImpl", "DATA Remote: ${this}")
                                localDataSource.insertAll(this.data.map { question -> question.toQuestionEntity() })
                                emit(Resource.Success(this.data))
                            } else -> {}
                        }
                    }
                }
            }
        }
    }.flowOn(Dispatchers.IO)
}