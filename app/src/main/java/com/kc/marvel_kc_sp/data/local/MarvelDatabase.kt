package com.kc.marvel_kc_sp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kc.marvel_kc_sp.domain.model.ListCharacterLocal


@Database(entities = [ListCharacterLocal::class], version = 1)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun marvelDao(): MarvelDao
}