package com.obo.opo.bomberos.domain.useCase.questions

data class QuestionsUseCase(

    val getQuestionsUseCase: GetQuestionsUseCase,

    val findByThemeUseCase: FindByThemeUseCase,

    val divideQuestionsUseCase: DivideQuestionsUseCase
)
