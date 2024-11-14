package com.obo.opo.bomberos.data.repository

import android.util.Log
import com.obo.opo.bomberos.data.dataSource.local.BlocksLocalDataSource
import com.obo.opo.bomberos.data.dataSource.local.TemariesLocalDataSource
import com.obo.opo.bomberos.data.dataSource.remote.TemaryRemoteDataSource
import com.obo.opo.bomberos.data.mapper.toBlock
import com.obo.opo.bomberos.data.mapper.toBlockEntity
import com.obo.opo.bomberos.data.mapper.toTemary
import com.obo.opo.bomberos.data.mapper.toTemaryEntity
import com.obo.opo.bomberos.domain.model.Block
import com.obo.opo.bomberos.domain.model.Temary
import com.obo.opo.bomberos.domain.repository.BlockRepository
import com.obo.opo.bomberos.domain.repository.TemaryRepository
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.util.ResponseToRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TemariesRepositoryImpl(
    private val remoteDataSource: TemaryRemoteDataSource,
    private val localDataSource: TemariesLocalDataSource
): TemaryRepository
    {

    // TEMARIES
    override fun getTemaries(): Flow<Resource<List<Temary>>> = flow {

        // GET TEMARIES DE LA BASE DE DATOS LOCAL SI NO ESTA VACIA. SINO INSERTA
        localDataSource.getTemaries().collect() {
            it.run {
                if (this.isNotEmpty()) {
                    Log.d("TemariesRepositoryImpl", "DATA LOCAL: ${this}")
                    // MAPEAMOS DATA A REMOTE
                    emit(Resource.Success(this.map { temaryEntity -> temaryEntity.toTemary() }))
                } else {
                    ResponseToRequest.send(remoteDataSource.getTemaries()).run {
                        when(this) {
                            is Resource.Success -> {
                                Log.d("TemariesRepositoryImpl", "DATA REMOTE: ${this}")
                                // MAPEAMOS DATA A ENTITY
                                localDataSource.insertAll(this.data.map { temary ->  temary.toTemaryEntity()})
                                emit(Resource.Success(this.data))
                            }
                            else -> {}
                        }
                    }
                }
            }
        }

        /*trySend(ResponseToRequest.send(remoteDataSource.getTemaries()))
        awaitClose{
            cancel()
        }*/
    }.flowOn(Dispatchers.IO) // Hilo

}