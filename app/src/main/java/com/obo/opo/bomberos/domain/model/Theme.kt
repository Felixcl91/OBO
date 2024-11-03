package com.obo.opo.bomberos.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Theme(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("id_block") val id_block: String? = null

): Serializable {

    // tomar informacion del data class y retornar un json
    fun toJson(): String = Gson().toJson(this)

    // funcion estatica "le pasamos la data y nos va a devolver el TEMA"
    companion object {
        fun fromJson(data: String): Theme = Gson().fromJson(data, Theme::class.java)
    }
}
