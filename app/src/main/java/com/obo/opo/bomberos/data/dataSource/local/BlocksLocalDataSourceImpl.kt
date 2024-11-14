package com.obo.opo.bomberos.data.dataSource.local

import com.obo.opo.bomberos.data.dataSource.local.dao.BlockDao
import com.obo.opo.bomberos.data.dataSource.local.entity.BlockEntity
import kotlinx.coroutines.flow.Flow

class BlocksLocalDataSourceImpl(private val blockDao: BlockDao): BlocksLocalDataSource {

    override suspend fun create(block: BlockEntity) = blockDao.insert(block)

    override suspend fun insertAll(blocks: List<BlockEntity>) = blockDao.insertAll(blocks)

    override fun getBlocks(): Flow<List<BlockEntity>> = blockDao.getBlocks()

    override fun getBlockById(idTemary: String): Flow<List<BlockEntity>> = blockDao.getBlocksById(idTemary)


}