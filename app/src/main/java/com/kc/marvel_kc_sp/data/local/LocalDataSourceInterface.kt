package com.kc.marvel_kc_sp.data.local

import com.kc.marvel_kc_sp.data.local.model.ListCharacterLocal
import kotlinx.coroutines.flow.Flow

interface LocalDataSourceInterface {

    suspend fun getCharacters(page: Int): Flow<List<ListCharacterLocal>>

    suspend fun isStorageUsed(page: Int): Boolean

    suspend fun getCharacterById(id: Int): ListCharacterLocal

    suspend fun saveCharacters(characters: List<ListCharacterLocal>)

    suspend fun toggleFavorite(characterId: Int)

    suspend fun deleteCharacters()

}