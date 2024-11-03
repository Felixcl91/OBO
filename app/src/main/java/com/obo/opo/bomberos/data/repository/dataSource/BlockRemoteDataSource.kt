package com.obo.opo.bomberos.data.repository.dataSource

import com.obo.opo.bomberos.domain.model.Block
import retrofit2.Response

interface BlockRemoteDataSource {

    suspend fun findAll(): Response<List<Block>>

    suspend fun findByTemary(idTemary: String): Response<List<Block>>
}