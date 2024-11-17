package com.obo.opo.bomberos.domain.useCase.blocks

import com.obo.opo.bomberos.domain.repository.BlockRepository

class FindByTemaryUseCase(private val repository: BlockRepository) {

    suspend operator fun invoke(token: String, idTemary: String) =
        repository.findByTemary(token, idTemary)
}