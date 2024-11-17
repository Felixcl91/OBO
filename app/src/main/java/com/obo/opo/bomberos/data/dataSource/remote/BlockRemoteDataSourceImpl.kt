package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.data.dataSource.remote.service.BlockService
import com.obo.opo.bomberos.domain.model.Block
import retrofit2.Response

class BlockRemoteDataSourceImpl(private val blocksService: BlockService):
    BlockRemoteDataSource {

    // TODOS LOS BLOQUES
    override suspend fun findAll(token: String): Response<List<Block>> =
        blocksService.getBlocks(token)
    // LOS BLOQUES POR ID DE TEMARIO
    override suspend fun findByTemary(token: String, idTemary: String): Response<List<Block>> =
        blocksService.findByTemary(token, idTemary)


}