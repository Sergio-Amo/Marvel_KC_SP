package com.kc.marvel_kc_sp.data.network.model

import com.squareup.moshi.Json


// TODO: Decide which data to save, maybe just MarvelCharacterRemote and ignore all the rest?
data class MarvelRemote (
    @Json(name= "code") val code: Int, // K
//    @Json(name= "status") val status: String, //F
//    @Json(name= "copyright") val copyright: String, //F
//    @Json(name= "attributionText") val attributionText: String, //F
//    @Json(name= "attributionHTML") val attributionHTML: String, //F
//    @Json(name= "etag") val etag: String, //F
    @Json(name= "data") val data: DataRemote //K
)

data class DataRemote (
//    @Json(name= "offset") val offset: Int, //FROM
//    @Json(name= "limit") val limit: Int,  //TO
//    @Json(name= "total") val total: Int,  //TOTAL
//    @Json(name= "count") val count: Int,  //RETURNED
    @Json(name= "results") val results: List<MarvelCharacterRemote>
)

data class MarvelCharacterRemote (
    @Json(name= "id") val id: Int,
    @Json(name= "name") val name: String,
    @Json(name= "description") val description: String,
//    @Json(name= "modified") val modified: String,
    @Json(name= "thumbnail") val thumbnail: ThumbnailRemote,
//    @Json(name= "resourceURI") val resourceURI: String,
//    @Json(name= "comics") val comics: ComicsRemote,  // TODO: Decouple this
//    @Json(name= "series") val series: ComicsRemote,  // TODO: Decouple this
//    @Json(name= "stories") val stories: StoriesRemote,
//    @Json(name= "events") val events: ComicsRemote, // TODO: Decouple this
//    @Json(name= "urls") val urls: List<URLRemote>
)
/*
data class ComicsRemote (
    @Json(name= "available") val available: Int,
    @Json(name= "collectionURI") val collectionURI: String,
    @Json(name= "items") val items: List<ComicsItemRemote>,
    @Json(name= "returned") val returned: Int
)

data class ComicsItemRemote (
    @Json(name= "resourceURI") val resourceURI: String,
    @Json(name= "name") val name: String
)

data class StoriesRemote (
    @Json(name= "available") val available: Int,
    @Json(name= "collectionURI") val collectionURI: String,
    @Json(name= "items") val items: List<StoriesItemRemote>,
    @Json(name= "returned") val returned: Int
)

data class StoriesItemRemote (
    @Json(name= "resourceURI") val resourceURI: String,
    @Json(name= "name") val name: String,
    @Json(name= "type") val type: String
)*/

// I'm using a string INSTEAD of an enum for the extension cause as long as android supports it
// It will work even if the api starts returning webp, avif, heic or other formats...
data class ThumbnailRemote (
    @Json(name= "path") val path: String,
    @Json(name= "extension") val extension: String,
)
/*

data class URLRemote (
    @Json(name= "type") val type: String,
    @Json(name= "url") val url: String
)
*/
