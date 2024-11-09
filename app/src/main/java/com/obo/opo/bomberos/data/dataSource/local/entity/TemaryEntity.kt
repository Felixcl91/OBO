package com.obo.opo.bomberos.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "temaries")
data class TemaryEntity(
    @PrimaryKey(autoGenerate = true) var pk: Int = 0,
    @ColumnInfo(name = "id") var id: String = "",
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "description") var description: String = ""
)
