package com.obo.opo.bomberos.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Question(

    @SerializedName("id") val id: String? = null,
    @SerializedName("question") val question: String,
    @SerializedName("answer") val answer: String,
    @SerializedName("id_theme") val id_theme: String? = null,
    @SerializedName("relevance") val relevance: String? = null


): Serializable {

    // tomar informacion del data class y retornar un json
    fun toJson(): String = Gson().toJson(this)

    // funcion estatica "le pasamos la data y nos va a devolver la pregunta"
    companion object {
        fun fromJson(data: String): Question = Gson().fromJson(data, Question::class.java)
    }
}

