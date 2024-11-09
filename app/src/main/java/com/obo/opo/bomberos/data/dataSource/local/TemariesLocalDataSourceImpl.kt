package com.obo.opo.bomberos.data.dataSource.local

import com.obo.opo.bomberos.data.dataSource.local.dao.TemariesDao
import com.obo.opo.bomberos.data.dataSource.local.entity.TemaryEntity
import kotlinx.coroutines.flow.Flow

class TemariesLocalDataSourceImpl(private val temariesDao: TemariesDao): TemariesLocalDataSource {

    override suspend fun create(temary: TemaryEntity) = temariesDao.insert(temary)
    override suspend fun insertAll(temaries: List<TemaryEntity>) = temariesDao.insertAll(temaries)
    override fun getTemaries(): Flow<List<TemaryEntity>> = temariesDao.getTemaries()
}