package com.kc.marvel_kc_sp.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kc.marvel_kc_sp.data.local.model.ListCharacterLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDao {

    @Query("SELECT EXISTS (SELECT 1 FROM marvel_characters WHERE page = :page)")
    suspend fun isStorageUsed(page: Int): Boolean

    @Query("SELECT * FROM marvel_characters WHERE page = :page ORDER BY name")
    fun getCharacters(page: Int): Flow<List<ListCharacterLocal>>

    @Query("SELECT * FROM marvel_characters WHERE id = :id LIMIT 1")
    suspend fun getCharacterById(id: Int): ListCharacterLocal

    @Insert
    suspend fun saveCharacters(characters: List<ListCharacterLocal>)

    @Update
    suspend fun updateCharacter(characters: ListCharacterLocal)

    @Query("DELETE FROM marvel_characters")
    suspend fun deleteCharacters()
}