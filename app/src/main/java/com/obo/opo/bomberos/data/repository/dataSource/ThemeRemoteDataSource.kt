package com.obo.opo.bomberos.data.repository.dataSource

import com.obo.opo.bomberos.domain.model.Theme
import retrofit2.Response

interface ThemeRemoteDataSource {

    suspend fun findAll(): Response<List<Theme>>

    suspend fun findByBlock(idBlock: String): Response<List<Theme>>
}