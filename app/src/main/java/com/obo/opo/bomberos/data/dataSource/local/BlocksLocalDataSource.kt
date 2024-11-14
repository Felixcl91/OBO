package com.obo.opo.bomberos.data.dataSource.local

import com.obo.opo.bomberos.data.dataSource.local.entity.BlockEntity
import kotlinx.coroutines.flow.Flow

interface BlocksLocalDataSource {

    suspend fun create(block: BlockEntity)
    suspend fun insertAll(blocks: List<BlockEntity>)
    fun getBlocks(): Flow<List<BlockEntity>>
    fun getBlockById(idTemary: String): Flow<List<BlockEntity>>
}