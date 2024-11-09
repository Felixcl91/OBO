package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.data.dataSource.remote.service.BlockService
import com.obo.opo.bomberos.domain.model.Block
import retrofit2.Response

class BlockRemoteDataSourceImpl(private val blocksService: BlockService):
    BlockRemoteDataSource {

    // TODOS LOS BLOQUES
    override suspend fun findAll(): Response<List<Block>> = blocksService.getBlocks(
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NSwibmFtZSI6IkNhdGFwbGFzbWEiLCJpYXQiOjE3MjkwOTE1ODYsImV4cCI6MTczMTY4MzU4Nn0.gw17GpHz_ZT8GnsiTfnc2F1VsQ1hTQ-4R63VJUl2ApA"
        )
    // LOS BLOQUES POR ID DE TEMARIO
    override suspend fun findByTemary(idTemary: String): Response<List<Block>> =
        blocksService.findByTemary(
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NSwibmFtZSI6IkNhdGFwbGFzbWEiLCJpYXQiOjE3MjkwOTE1ODYsImV4cCI6MTczMTY4MzU4Nn0.gw17GpHz_ZT8GnsiTfnc2F1VsQ1hTQ-4R63VJUl2ApA",
            idTemary
        )


}