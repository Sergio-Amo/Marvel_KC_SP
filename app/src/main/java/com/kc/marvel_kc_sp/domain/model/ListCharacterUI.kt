package com.kc.marvel_kc_sp.domain.model

data class ListCharacterUI(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail,
    val favorite: Boolean,
    val inPage: Int,
)