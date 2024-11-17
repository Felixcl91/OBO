package com.obo.opo.bomberos.domain.useCase.questions

import com.obo.opo.bomberos.domain.repository.QuestionRepository

class GetQuestionsUseCase(private val repository: QuestionRepository) {

    suspend operator fun invoke(token: String) = repository.getQuestions(token)
}