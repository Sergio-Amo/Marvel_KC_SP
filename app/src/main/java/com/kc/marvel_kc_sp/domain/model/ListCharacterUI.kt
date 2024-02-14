package com.kc.marvel_kc_sp.domain.model

data class ListCharacterUI(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String,
    val favorite: Boolean,
    val page: Int,
)

// TODO: Separate character ui for list and description