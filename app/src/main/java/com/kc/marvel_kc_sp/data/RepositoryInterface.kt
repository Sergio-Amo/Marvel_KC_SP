package com.kc.marvel_kc_sp.data

import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {

    suspend fun getCharacters(page: Int): Flow<List<ListCharacterUI>>
}