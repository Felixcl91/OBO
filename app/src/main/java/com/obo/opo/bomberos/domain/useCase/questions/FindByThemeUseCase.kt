package com.obo.opo.bomberos.domain.useCase.questions

import com.obo.opo.bomberos.domain.repository.QuestionRepository

class FindByThemeUseCase(private val repository: QuestionRepository) {

    suspend operator fun invoke(token: String, idTheme: String) =
        repository.findByTheme(token, idTheme)
}