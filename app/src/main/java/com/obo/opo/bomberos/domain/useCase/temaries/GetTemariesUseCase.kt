package com.obo.opo.bomberos.domain.useCase.temaries

import com.obo.opo.bomberos.domain.repository.TemaryRepository

class GetTemariesUseCase(private val repository: TemaryRepository) {

    suspend operator fun invoke() = repository.getTemaries()

}