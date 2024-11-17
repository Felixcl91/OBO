package com.obo.opo.bomberos.domain.useCase.themes

import com.obo.opo.bomberos.domain.repository.ThemeRepository

class FindByBlockUseCase(private val repository: ThemeRepository) {

    suspend operator fun invoke(token: String, idBlock: String) = repository.findByBlock(token, idBlock)
}