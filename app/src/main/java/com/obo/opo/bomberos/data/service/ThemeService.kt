package com.obo.opo.bomberos.data.service

import com.obo.opo.bomberos.domain.model.Block
import com.obo.opo.bomberos.domain.model.Temary
import com.obo.opo.bomberos.domain.model.Theme
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ThemeService {

    // http://192.168.119.214:3000/themes
    // asincrono
    @GET("themes")
    suspend fun getThemes(
        @Header("Authorization") token: String
    ): Response<List<Theme>>

    // http://192.168.179.214:3000/themes/block/{id_block}
    // asincrono
    @GET("themes/block/{id_block}")
    suspend fun findByBlock(
        @Header("Authorization") token: String,
        @Path("id_block") idBlock: String
    ): Response<List<Theme>>
}