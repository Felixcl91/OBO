package com.obo.opo.bomberos.domain.repository

import com.obo.opo.bomberos.domain.model.Block
import com.obo.opo.bomberos.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface BlockRepository {

    fun getBlocks(): Flow<Resource<List<Block>>>

    fun findByTemary(idTemary: String): Flow<Resource<List<Block>>>
}