package com.obo.opo.bomberos.domain.repository

import com.obo.opo.bomberos.domain.model.Theme
import com.obo.opo.bomberos.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ThemeRepository {

    fun getThemes(token: String): Flow<Resource<List<Theme>>>

    fun findByBlock(token: String, idBlock: String): Flow<Resource<List<Theme>>>
}