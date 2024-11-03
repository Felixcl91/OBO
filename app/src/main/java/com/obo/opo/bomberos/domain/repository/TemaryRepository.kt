package com.obo.opo.bomberos.domain.repository

import com.obo.opo.bomberos.domain.model.Temary
import com.obo.opo.bomberos.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface TemaryRepository {

    fun getTemaries(): Flow<Resource<List<Temary>>>
}