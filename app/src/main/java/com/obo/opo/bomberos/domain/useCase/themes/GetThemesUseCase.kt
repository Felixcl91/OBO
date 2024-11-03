package com.obo.opo.bomberos.domain.useCase.themes

import com.obo.opo.bomberos.domain.repository.ThemeRepository

class GetThemesUseCase(private val repository: ThemeRepository) {

    suspend operator fun invoke() = repository.getThemes()
}