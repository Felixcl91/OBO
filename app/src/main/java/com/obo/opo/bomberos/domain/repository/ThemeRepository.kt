package com.obo.opo.bomberos.domain.repository

import com.obo.opo.bomberos.domain.model.Theme
import com.obo.opo.bomberos.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ThemeRepository {

    fun getThemes(): Flow<Resource<List<Theme>>>

    fun findByBlock(idBlock: String): Flow<Resource<List<Theme>>>
}