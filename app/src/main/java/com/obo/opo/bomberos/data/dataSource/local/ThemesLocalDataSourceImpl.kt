package com.obo.opo.bomberos.data.dataSource.local

import com.obo.opo.bomberos.data.dataSource.local.dao.ThemeDao
import com.obo.opo.bomberos.data.dataSource.local.entity.ThemeEntity
import kotlinx.coroutines.flow.Flow

class ThemesLocalDataSourceImpl(private val themeDao: ThemeDao): ThemesLocalDataSource {

    override suspend fun create(theme: ThemeEntity) = themeDao.insert(theme)

    override suspend fun insertAll(themes: List<ThemeEntity>) = themeDao.insertAll(themes)

    override fun getThemes(): Flow<List<ThemeEntity>> = themeDao.getThemes()

    override fun getThemeById(idBlock: String): Flow<List<ThemeEntity>> = themeDao.getThemesById(idBlock)
}