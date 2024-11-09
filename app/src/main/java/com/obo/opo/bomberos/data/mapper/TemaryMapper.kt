package com.obo.opo.bomberos.data.mapper

import com.obo.opo.bomberos.data.dataSource.local.entity.TemaryEntity
import com.obo.opo.bomberos.domain.model.Temary

fun TemaryEntity.toTemary(): Temary {

    return Temary(
        id = id,
        name = name,
        description = description
    )
}

fun Temary.toTemaryEntity(): TemaryEntity {

    return TemaryEntity(
        id = id ?: "",
        name = name,
        description = description
    )
}

