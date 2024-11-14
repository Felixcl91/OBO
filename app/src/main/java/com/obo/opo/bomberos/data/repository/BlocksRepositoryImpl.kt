package com.obo.opo.bomberos.data.repository

import android.util.Log
import com.obo.opo.bomberos.data.dataSource.local.BlocksLocalDataSource
import com.obo.opo.bomberos.data.dataSource.remote.BlockRemoteDataSource
import com.obo.opo.bomberos.data.mapper.toBlock
import com.obo.opo.bomberos.data.mapper.toBlockEntity
import com.obo.opo.bomberos.data.mapper.toTemary
import com.obo.opo.bomberos.data.mapper.toTemaryEntity
import com.obo.opo.bomberos.domain.model.Block
import com.obo.opo.bomberos.domain.repository.BlockRepository
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.util.ResponseToRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class BlocksRepositoryImpl(
    private val remoteDataSource: BlockRemoteDataSource,
    private val localDataSource: BlocksLocalDataSource
): BlockRepository {

    override fun getBlocks(): Flow<Resource<List<Block>>> = callbackFlow {
        trySend(ResponseToRequest.send(remoteDataSource.findAll()))
        awaitClose {
            cancel()
        }
    }

    override fun findByTemary(idTemary: String): Flow<Resource<List<Block>>> = flow {

        localDataSource.getBlockById(idTemary).collect() {
            it.run {
                if (this.isNotEmpty()) {
                    Log.d("BlocksRepositoryImpl", "DATA LOCAL: ${this}")
                    // MAPEAMOS DATA A REMOTE
                    emit(Resource.Success(this.map { blockEntity -> blockEntity.toBlock() }))
                } else {
                    ResponseToRequest.send(remoteDataSource.findByTemary(idTemary)).run {
                        when(this) {
                            is Resource.Success -> {
                                Log.d("BlocksRepositoryImpl", "DATA REMOTE: ${this}")
                                // MAPEAMOS DATA A ENTITY
                                localDataSource.insertAll(this.data.map { block ->  block.toBlockEntity()})
                                emit(Resource.Success(this.data))
                            }
                            else -> {}
                        }
                    }
                }
            }

            /*it.run {
                val blocksLocalMap = this.map { blockEntity -> blockEntity.toBlock() }
                try {
                    ResponseToRequest.send(remoteDataSource.findByTemary(idTemary)).run {
                        when (this) {
                            is Resource.Success -> {
                                val blocksRemote = this.data
                                localDataSource.insertAll(blocksRemote.map { block -> block.toBlockEntity() })
                                emit(Resource.Success(blocksRemote))
                                Log.d("BlocksRepositoryImpl", "DATA LOCAL: ${this}")
                            }

                            else -> {
                                emit(Resource.Success(blocksLocalMap))
                            }
                        }

                    }

                } catch (e: Exception) {
                    emit(Resource.Success(blocksLocalMap))
                }
            }*/
        }
    }.flowOn(Dispatchers.IO) // Hilo


}