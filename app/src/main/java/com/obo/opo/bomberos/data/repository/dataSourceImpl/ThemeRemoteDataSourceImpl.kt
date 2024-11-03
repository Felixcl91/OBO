package com.obo.opo.bomberos.data.repository.dataSourceImpl

import com.obo.opo.bomberos.data.repository.dataSource.ThemeRemoteDataSource
import com.obo.opo.bomberos.data.service.ThemeService
import com.obo.opo.bomberos.domain.model.Theme
import retrofit2.Response

class ThemeRemoteDataSourceImpl(private val themeService: ThemeService): ThemeRemoteDataSource {


    override suspend fun findAll(): Response<List<Theme>> = themeService.getThemes(
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NSwibmFtZSI6IkNhdGFwbGFzbWEiLCJpYXQiOjE3MjkwOTE1ODYsImV4cCI6MTczMTY4MzU4Nn0.gw17GpHz_ZT8GnsiTfnc2F1VsQ1hTQ-4R63VJUl2ApA"
    )

    override suspend fun findByBlock(idBlock: String): Response<List<Theme>> =
        themeService.findByBlock(
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NSwibmFtZSI6IkNhdGFwbGFzbWEiLCJpYXQiOjE3MjkwOTE1ODYsImV4cCI6MTczMTY4MzU4Nn0.gw17GpHz_ZT8GnsiTfnc2F1VsQ1hTQ-4R63VJUl2ApA",
            idBlock

        )

}