package com.obo.opo.bomberos.data.dataSource.remote.service

import com.obo.opo.bomberos.domain.model.Block
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface BlockService {

    // http://192.168.255.214:3000/blocks/
    // asincrono
    @GET("blocks")
    suspend fun getBlocks(
        @Header("Authorization") token: String
    ): Response<List<Block>>

    // http://192.168.179.214:3000/blocks/temary/1
    // asincrono
    @GET("blocks/temary/{id_temary}")
    suspend fun findByTemary(
        @Header("Authorization") token: String,
        @Path("id_temary") idTemary: String
    ): Response<List<Block>>
}