package com.obo.opo.bomberos.domain.useCase.questions

import android.util.Log
import com.obo.opo.bomberos.domain.model.Question

class DivideQuestionsUseCase {

    /*operator fun invoke(questions: List<Question>): List<List<Question>> {
        val maxParts = 5
        val minQuestionsPerPart = 100

        // Determinar el número de partes necesario, sin exceder el máximo de 5
        val parts = (questions.size / minQuestionsPerPart).coerceAtMost(maxParts)

        Log.d("DivideQuestionsUseCase", "Partes: $parts")

        // Si no se requiere dividir (menos de 100 preguntas), devolver la lista completa en una sola "parte"
        if (parts <= 1) return listOf(questions)

        // Calcular la cantidad de preguntas por cada parte
        val questionsPerPart = questions.size / parts
        val dividedQuestions = mutableListOf<List<Question>>()

        for (i in 0 until parts) {
            val start = i * questionsPerPart
            val end = if (i == parts - 1) questions.size else (i + 1) * questionsPerPart
            dividedQuestions.add(questions.subList(start, end))
        }

        return dividedQuestions
    }*/

    operator fun invoke(questions: List<Question>): Pair<List<Question>, List<Question>> {
        return if (questions.size > 100) {
            val midPoint = questions.size / 2
            questions.take(midPoint) to questions.drop(midPoint)
        }
        else {
            questions to emptyList()
        }
    }
}