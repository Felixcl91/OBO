package com.obo.opo.bomberos.data.repository

import com.obo.opo.bomberos.data.repository.dataSource.BlockRemoteDataSource
import com.obo.opo.bomberos.domain.model.Block
import com.obo.opo.bomberos.domain.repository.BlockRepository
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.util.ResponseToRequest
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class BlocksRepositoryImpl(private val blockRemoteDataSource: BlockRemoteDataSource): BlockRepository {

    override fun getBlocks(): Flow<Resource<List<Block>>> = callbackFlow {
        trySend(ResponseToRequest.send(blockRemoteDataSource.findAll()))
        awaitClose {
            cancel()
        }
    }

    override fun findByTemary(idTemary: String): Flow<Resource<List<Block>>> = flow {
        emit(ResponseToRequest.send(
            blockRemoteDataSource.findByTemary(idTemary)
        ))
    }


}