package com.kc.marvel_kc_sp.data.network.model

import com.squareup.moshi.Json

data class SeriesRemoteResponse(
    @Json(name = "data") val data: SeriesData,
)

data class SeriesData(
    @Json(name = "results") val results: List<SeriesRemote>,
)

data class SeriesRemote(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "thumbnail") val thumbnail: SeriesThumbnail,
)

data class SeriesThumbnail(
    @Json(name = "path") val path: String,
    @Json(name = "extension") val extension: String,
)