package com.obo.opo.bomberos.data.repository

import com.obo.opo.bomberos.data.repository.dataSource.TemaryRemoteDataSource
import com.obo.opo.bomberos.domain.model.Temary
import com.obo.opo.bomberos.domain.repository.TemaryRepository
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.util.ResponseToRequest
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class TemariesRepositoryImpl(
    private val temaryRemoteDataSource: TemaryRemoteDataSource
): TemaryRepository {

    override fun getTemaries(): Flow<Resource<List<Temary>>> = callbackFlow {
        trySend(ResponseToRequest.send(temaryRemoteDataSource.getTemaries()))
        awaitClose{
            cancel()
        }
    }


}