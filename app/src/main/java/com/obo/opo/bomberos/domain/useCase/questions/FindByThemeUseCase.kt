package com.obo.opo.bomberos.domain.useCase.questions

import com.obo.opo.bomberos.domain.repository.QuestionRepository

class FindByThemeUseCase(private val repository: QuestionRepository) {

    suspend operator fun invoke(idTheme: String) = repository.findByTheme(idTheme)
}