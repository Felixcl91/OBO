package com.obo.opo.bomberos.domain.useCase.blocks

data class BlocksUseCase(

    val getBlocksUseCase: GetBlocksUseCase,

    val findByTemaryUseCase: FindByTemaryUseCase
)
