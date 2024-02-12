package com.kc.marvel_kc_sp.data

interface RepositoryInterface {
    suspend fun getCharacters()
}