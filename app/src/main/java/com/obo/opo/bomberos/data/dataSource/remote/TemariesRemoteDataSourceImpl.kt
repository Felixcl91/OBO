package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.data.dataSource.remote.service.TemaryService
import com.obo.opo.bomberos.domain.model.Temary
import retrofit2.Response

class TemariesRemoteDataSourceImpl(private val temaryService: TemaryService):
    TemaryRemoteDataSource {

    override suspend fun getTemaries(): Response<List<Temary>> = temaryService.getTemaries(
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NSwibmFtZSI6IkNhdGFwbGFzbWEiLCJpYXQiOjE3MjkwOTE1ODYsImV4cCI6MTczMTY4MzU4Nn0.gw17GpHz_ZT8GnsiTfnc2F1VsQ1hTQ-4R63VJUl2ApA"
    )


}