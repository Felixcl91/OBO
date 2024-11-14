package com.obo.opo.bomberos.data.mapper

import com.obo.opo.bomberos.data.dataSource.local.entity.ThemeEntity
import com.obo.opo.bomberos.domain.model.Theme

fun ThemeEntity.toTheme(): Theme {

    return Theme(
        id = id,
        name = name,
        description = description,
        id_block = id_block
    )
}

fun Theme.toThemeEntity(): ThemeEntity {

    return ThemeEntity(
        id = id ?: "",
        name = name,
        description = description,
        id_block = id_block ?: ""
    )
}

