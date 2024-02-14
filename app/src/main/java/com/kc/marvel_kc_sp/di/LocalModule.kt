package com.kc.marvel_kc_sp.di

import android.content.Context
import androidx.room.Room
import com.kc.marvel_kc_sp.data.local.LocalDataSourceImpl
import com.kc.marvel_kc_sp.data.local.LocalDataSourceInterface
import com.kc.marvel_kc_sp.data.local.db.MarvelDao
import com.kc.marvel_kc_sp.data.local.db.MarvelDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun providesMarvelDatabase(@ApplicationContext context: Context): MarvelDatabase {
        return Room.databaseBuilder(
            context,
            MarvelDatabase::class.java, "marvel-database"
        ).build()
    }

    @Provides
    fun providesMarvelDao(db: MarvelDatabase): MarvelDao {
        return db.getDAO()
    }

    @Provides
    fun providesLocalDataSourceInterface(source: LocalDataSourceImpl): LocalDataSourceInterface =
        source

}