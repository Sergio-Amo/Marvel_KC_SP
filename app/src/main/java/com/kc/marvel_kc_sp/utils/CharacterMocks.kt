package com.kc.marvel_kc_sp.utils

import com.kc.marvel_kc_sp.domain.model.ListCharacterUI

object CharacterMocks {
    fun generateCharactersUI(size: Int) = (0 until size).map {
        ListCharacterUI(
            it,
            "A marvel character name $it",
            "Description $it",
            "https://i.annihil.us/u/prod/marvel/i/mg/9/c0/527bb7b37ff55/landscape_incredible.jpg",
            it % 3 == 0,
            it,
        )
    }
}