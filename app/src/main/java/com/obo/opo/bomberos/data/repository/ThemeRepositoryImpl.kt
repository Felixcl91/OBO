package com.obo.opo.bomberos.data.repository

import android.util.Log
import com.obo.opo.bomberos.data.dataSource.local.ThemesLocalDataSource
import com.obo.opo.bomberos.data.dataSource.remote.ThemeRemoteDataSource
import com.obo.opo.bomberos.data.mapper.toTheme
import com.obo.opo.bomberos.data.mapper.toThemeEntity
import com.obo.opo.bomberos.domain.model.Theme
import com.obo.opo.bomberos.domain.repository.ThemeRepository
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.domain.util.ResponseToRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class ThemeRepositoryImpl(
    private val remoteDataSource: ThemeRemoteDataSource,
    private val localDataSource: ThemesLocalDataSource
): ThemeRepository {

    override fun getThemes(token: String): Flow<Resource<List<Theme>>> = callbackFlow {
        trySend(ResponseToRequest.send(remoteDataSource.findAll(token)))
        awaitClose {
            cancel()
        }
    }

    override fun findByBlock(token: String, idBlock: String): Flow<Resource<List<Theme>>> = flow {

        localDataSource.getThemeById(idBlock).collect() {
            it.run {
                if (this.isNotEmpty()) {
                    Log.d("ThemeRepositoryImpl", "DATA Local: ${this}")
                    emit(Resource.Success(this.map { themeEntity ->  themeEntity.toTheme()}))
                } else {
                    ResponseToRequest.send(remoteDataSource.findByBlock(token, idBlock)).run {
                        when(this) {
                            is Resource.Success -> {
                                Log.d("ThemeRepositoryImpl", "DATA Remote: ${this}")
                                localDataSource.insertAll(this.data.map { theme ->  theme.toThemeEntity()})
                                emit(Resource.Success(this.data))

                            } else -> {}
                        }
                    }
                }
            }
        }

    }.flowOn(Dispatchers.IO)
}