package com.kc.marvel_kc_sp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kc.marvel_kc_sp.domain.model.ListCharacterLocal

@Dao
interface MarvelDao {

    @Query("SELECT * FROM marvel_characters WHERE page = :page")
    suspend fun getCharacters(page: Int): List<ListCharacterLocal>

    @Query("SELECT * FROM marvel_characters WHERE id = :id LIMIT 1")
    suspend fun getCharacterById(id: String): ListCharacterLocal

    @Insert
    suspend fun saveCharacters(characters: List<ListCharacterLocal>)

    @Update
    suspend fun updateCharacter(characters: ListCharacterLocal)

    @Query("DELETE FROM marvel_characters")
    suspend fun deleteCharacters()
}