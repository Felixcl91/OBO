package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.domain.model.Block
import retrofit2.Response

interface BlockRemoteDataSource {

    suspend fun findAll(token: String): Response<List<Block>>

    suspend fun findByTemary(token: String, idTemary: String): Response<List<Block>>
}