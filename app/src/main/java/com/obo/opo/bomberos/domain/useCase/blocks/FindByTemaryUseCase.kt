package com.obo.opo.bomberos.domain.useCase.blocks

import com.obo.opo.bomberos.domain.repository.BlockRepository

class FindByTemaryUseCase(private val repository: BlockRepository) {

    suspend operator fun invoke(idTemary: String) = repository.findByTemary(idTemary)
}