package com.kc.marvel_kc_sp.utils

import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.domain.model.SeriesUI
import kotlin.random.Random

object Mocks {
    fun generateCharactersUI(size: Int) = (0 until size).map {
        ListCharacterUI(
            it,
            "${randomString(20)} $it",
            "Description: ${randomString(2000)}",
            "https://i.annihil.us/u/prod/marvel/i/mg/9/c0/527bb7b37ff55/landscape_incredible.jpg",
            it % 3 == 0,
            it,
        )
    }

    fun randomString(size: Int): String {
        val permittedChars: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9') + (' ')
        return (1..Random.nextInt(5, size + 1)).map {
            Random.nextInt(0, permittedChars.size).let { permittedChars[it] }
        }.joinToString("")
    }

    fun generateSeriesUI(size: Int): List<SeriesUI> = (0 until size).map {
        SeriesUI(
            it,
            "${randomString(20)} $it",
            "https://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available/portrait_incredible.jpg"
        )
    }
}