package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.domain.model.Temary
import retrofit2.Response

interface TemaryRemoteDataSource {

    suspend fun getTemaries(): Response<List<Temary>>
}