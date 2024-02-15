package com.kc.marvel_kc_sp.data.network

import com.kc.marvel_kc_sp.data.network.model.DataRemote
import com.kc.marvel_kc_sp.data.network.model.MarvelCharacterRemote
import kotlinx.coroutines.flow.Flow

interface NetworkDataSourceInterface {
    suspend fun getCharacters(page: Int): DataRemote
    suspend fun getDetails(id: Int): Flow<MarvelCharacterRemote>
}