package com.kc.marvel_kc_sp.data.network.model

import com.squareup.moshi.Json

data class MarvelRemote(
    @Json(name = "code") val code: Int,
    @Json(name = "data") val data: DataRemote,
)

data class DataRemote(
    @Json(name = "results") val results: List<MarvelCharacterRemote>,
)

data class MarvelCharacterRemote(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "thumbnail") val thumbnail: ThumbnailRemote,
)

// I'm using a string INSTEAD of an enum for the extension cause as long as android supports it
// It will work even if the api starts returning webp, avif, heic or other formats...
data class ThumbnailRemote(
    @Json(name = "path") val path: String,
    @Json(name = "extension") val extension: String,
)

