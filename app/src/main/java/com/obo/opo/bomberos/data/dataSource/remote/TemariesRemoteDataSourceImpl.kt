package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.data.dataSource.remote.service.TemaryService
import com.obo.opo.bomberos.domain.model.Temary
import retrofit2.Response

class TemariesRemoteDataSourceImpl(
    private val temaryService: TemaryService
    ):
    TemaryRemoteDataSource {

    override suspend fun getTemaries(token: String): Response<List<Temary>> =
        temaryService.getTemaries(token)


}