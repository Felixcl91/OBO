package com.obo.opo.bomberos.data.dataSource.local

import com.obo.opo.bomberos.data.dataSource.local.entity.ThemeEntity
import kotlinx.coroutines.flow.Flow

interface ThemesLocalDataSource {

    suspend fun create(theme: ThemeEntity)
    suspend fun insertAll(themes: List<ThemeEntity>)
    fun getThemes(): Flow<List<ThemeEntity>>
    fun getThemeById(idBlock: String): Flow<List<ThemeEntity>>
}