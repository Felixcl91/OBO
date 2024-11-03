package com.obo.opo.bomberos.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Temary(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String

): Serializable {

    // tomar informacion del data class y retornar un json
    fun toJson(): String = Gson().toJson(this)

    // funcion estatica "le pasamos la data y nos va a devolver el Temario"
    companion object {
        fun fromJson(data: String): Temary = Gson().fromJson(data, Temary::class.java)
    }
}
