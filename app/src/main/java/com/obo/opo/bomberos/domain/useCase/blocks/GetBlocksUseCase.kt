package com.obo.opo.bomberos.domain.useCase.blocks

import com.obo.opo.bomberos.domain.repository.BlockRepository

class GetBlocksUseCase(private val repository: BlockRepository) {

    suspend operator fun invoke(token: String) = repository.getBlocks(token)
}