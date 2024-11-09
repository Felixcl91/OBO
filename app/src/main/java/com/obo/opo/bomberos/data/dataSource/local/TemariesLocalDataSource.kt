package com.obo.opo.bomberos.data.dataSource.local

import com.obo.opo.bomberos.data.dataSource.local.entity.TemaryEntity
import kotlinx.coroutines.flow.Flow

interface TemariesLocalDataSource {

    suspend fun create(temary: TemaryEntity)
    suspend fun insertAll(temaries: List<TemaryEntity>)
    fun getTemaries(): Flow<List<TemaryEntity>>
}