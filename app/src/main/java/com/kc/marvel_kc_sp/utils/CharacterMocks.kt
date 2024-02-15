package com.kc.marvel_kc_sp.utils

import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import kotlin.random.Random

object CharacterMocks {
    fun generateCharactersUI(size: Int) = (0 until size).map {
        ListCharacterUI(
            it,
            "${randomString(20)} $it",
            "Description $it",
            "https://i.annihil.us/u/prod/marvel/i/mg/9/c0/527bb7b37ff55/landscape_incredible.jpg",
            it % 3 == 0,
            it,
        )
    }

    private fun randomString(size: Int): String {
        val permittedChars: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (1..Random.nextInt(5, size+1)).map {
            Random.nextInt(0, permittedChars.size).let { permittedChars[it] }
        }.joinToString("")
    }
}