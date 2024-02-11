package com.kc.marvel_kc_sp.domain.model

data class Marvel (
    val code: Int, // K
    val status: String, //F
    val copyright: String, //F
    val attributionText: String, //F
    val attributionHTML: String, //F
    val etag: String, //F
    val data: Data //K
)

data class Data (
    val offset: Int, //FROM
    val limit: Int,  //TO
    val total: Int,  //TOTAL
    val count: Int,  //RETURNED
    val results: List<MarvelCharacter> // ListOfCharacters
)

data class MarvelCharacter (
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,  // TODO: remove?
    val thumbnail: Thumbnail,
    val resourceURI: String,  // TODO: remove?
    val comics: Comics,  // TODO: Decouple this
    val series: Comics,  // TODO: Decouple this
    val stories: Stories,
    val events: Comics, // TODO: Decouple this
    val urls: List<URL> // TODO: remove?
)

data class Comics (
    val available: Int,
    val collectionURI: String,
    val items: List<ComicsItem>,
    val returned: Int
)

data class ComicsItem (
    val resourceURI: String,
    val name: String
)

data class Stories (
    val available: Int,
    val collectionURI: String,
    val items: List<StoriesItem>,
    val returned: Int
)

data class StoriesItem (
    val resourceURI: String,
    val name: String,
    val type: String
)

// I'm using a string INSTEAD of an enum for the extension cause as long as android supports it
// It will work even if the api starts returning webp, avif, heic or other formats...
data class Thumbnail (
    val path: String,
    val extension: String,
)

data class URL (
    val type: URLType,
    val url: String
)

// TODO: consider what to do with this
enum class URLType {
    Comiclink,
    Detail,
    Wiki
}

