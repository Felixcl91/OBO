package com.obo.opo.bomberos.data.repository

import com.obo.opo.bomberos.data.repository.dataSource.ThemeRemoteDataSource
import com.obo.opo.bomberos.domain.model.Theme
import com.obo.opo.bomberos.domain.repository.ThemeRepository
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.util.ResponseToRequest
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow


class ThemeRepositoryImpl(private val themeRemoteDataSource: ThemeRemoteDataSource): ThemeRepository {

    override fun getThemes(): Flow<Resource<List<Theme>>> = callbackFlow {
        trySend(ResponseToRequest.send(themeRemoteDataSource.findAll()))
        awaitClose {
            cancel()
        }
    }

    override fun findByBlock(idBlock: String): Flow<Resource<List<Theme>>> = flow {
        emit(ResponseToRequest.send(
            themeRemoteDataSource.findByBlock(idBlock)
        ))
    }
}