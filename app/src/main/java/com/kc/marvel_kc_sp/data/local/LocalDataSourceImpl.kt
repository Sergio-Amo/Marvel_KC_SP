package com.kc.marvel_kc_sp.data.local

import com.kc.marvel_kc_sp.data.local.db.MarvelDao
import com.kc.marvel_kc_sp.data.local.model.ListCharacterLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: MarvelDao) :
    LocalDataSourceInterface {

    override suspend fun getCharacters(page: Int): Flow<List<ListCharacterLocal>> {
        return dao.getCharacters(page)
    }

    override suspend fun getAllCharacters(): Flow<List<ListCharacterLocal>> {
        return dao.getAllCharacters()
    }

    override suspend fun isStorageUsed(page: Int): Boolean {
        return dao.isStorageUsed(page)
    }

    override suspend fun getCharacterById(id: Int): ListCharacterLocal {
        return dao.getCharacterById(id)
    }

    override suspend fun saveCharacters(characters: List<ListCharacterLocal>) {
        dao.saveCharacters(characters)
    }

    override suspend fun toggleFavorite(characterId: Int) {
        val character = getCharacterById(characterId)
        character.favorite = !character.favorite
        dao.updateCharacter(character)
    }

    override suspend fun deleteCharacters() {
        dao.deleteCharacters()
    }

}