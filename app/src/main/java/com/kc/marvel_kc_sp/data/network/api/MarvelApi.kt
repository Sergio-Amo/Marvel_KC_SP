package com.kc.marvel_kc_sp.data.network.api

import com.kc.marvel_kc_sp.data.network.model.MarvelRemote
import com.kc.marvel_kc_sp.data.network.model.SeriesRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    private companion object {
        private const val base: String = "https://gateway.marvel.com/v1/public"
        private const val charactersEndPoint: String = "$base/characters"
        private const val seriesEndPoint: String = "$base/characters/{characterId}/series"
        private const val heroLimit = 20
    }

    @GET(charactersEndPoint)
    suspend fun getCharacters(
        @Query("limit") limit: Int? = heroLimit,
        @Query("offset") offset: Int? = 0,
        @Query("orderBy") sort: String = "name",
    ): MarvelRemote


    // /v1/public/characters/{characterId}
    @GET("$charactersEndPoint/{characterId}")
    suspend fun getDetails(@Path("characterId") id: Int): MarvelRemote

    // /v1/public/characters/{characterId}/series
    @GET(seriesEndPoint)
    suspend fun getSeries(@Path("characterId") id: Int): SeriesRemoteResponse

}