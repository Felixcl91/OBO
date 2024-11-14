package com.obo.opo.bomberos.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true) var pk: Int = 0,
    @ColumnInfo(name = "id") var id: String = "",
    @ColumnInfo(name = "question") var question: String = "",
    @ColumnInfo(name = "answer") var answer: String = "",
    @ColumnInfo(name = "relevance") var relevance: String = "",
    @ColumnInfo(name = "id_theme") var id_theme: String = ""
)
