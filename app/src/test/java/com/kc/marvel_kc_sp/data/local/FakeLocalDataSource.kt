package com.kc.marvel_kc_sp.data.local

import com.kc.marvel_kc_sp.data.local.model.ListCharacterLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class FakeLocalDataSource : LocalDataSourceInterface {

    override suspend fun getCharacters(page: Int): Flow<List<ListCharacterLocal>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllCharacters(): Flow<List<ListCharacterLocal>> {
        val expected = listOf<ListCharacterLocal>(
            ListCharacterLocal(42, "test", "", "", false, 1)
        )
        return flowOf(expected)
    }

    override suspend fun getFavoriteCharacters(): Flow<List<ListCharacterLocal>> {
        TODO("Not yet implemented")
    }

    override suspend fun isStorageUsed(page: Int): Boolean {
        return true
    }

    override suspend fun getCharacterById(id: Int): ListCharacterLocal {
        TODO("Not yet implemented")
    }

    override suspend fun saveCharacters(characters: List<ListCharacterLocal>) {
        TODO("Not yet implemented")
    }

    override suspend fun toggleFavorite(characterId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCharacters() {
        TODO("Not yet implemented")
    }

}
