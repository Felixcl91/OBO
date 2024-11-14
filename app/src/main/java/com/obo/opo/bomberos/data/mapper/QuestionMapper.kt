package com.obo.opo.bomberos.data.mapper

import com.obo.opo.bomberos.data.dataSource.local.entity.QuestionEntity
import com.obo.opo.bomberos.data.dataSource.local.entity.TemaryEntity
import com.obo.opo.bomberos.domain.model.Question
import com.obo.opo.bomberos.domain.model.Temary

fun QuestionEntity.toQuestion(): Question {

    return Question(
        id = id,
        question = question,
        answer = answer,
        id_theme = id_theme,
        relevance = relevance
    )
}

fun Question.toQuestionEntity(): QuestionEntity {

    return QuestionEntity(
        id = id ?: "",
        question = question,
        answer = answer,
        id_theme = id_theme ?: "",
        relevance = relevance ?: ""
    )
}

