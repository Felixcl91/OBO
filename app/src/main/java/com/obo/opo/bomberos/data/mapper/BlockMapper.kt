package com.obo.opo.bomberos.data.mapper

import com.obo.opo.bomberos.data.dataSource.local.entity.BlockEntity
import com.obo.opo.bomberos.domain.model.Block

fun BlockEntity.toBlock(): Block {

    return Block(
        id = id,
        name = name,
        description = description,
        id_temary = id_temary
    )
}

fun Block.toBlockEntity(): BlockEntity {

    return BlockEntity(
        id = id ?: "",
        name = name,
        description = description,
        id_temary = id_temary ?: ""
    )
}

