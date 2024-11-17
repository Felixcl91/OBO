package com.obo.opo.bomberos.data.dataSource.remote

import com.obo.opo.bomberos.data.dataSource.remote.service.ThemeService
import com.obo.opo.bomberos.domain.model.Theme
import retrofit2.Response

class ThemeRemoteDataSourceImpl(private val themeService: ThemeService): ThemeRemoteDataSource {


    override suspend fun findAll(token: String): Response<List<Theme>> =
        themeService.getThemes(token)

    override suspend fun findByBlock(token: String, idBlock: String): Response<List<Theme>> =
        themeService.findByBlock(token, idBlock)

}