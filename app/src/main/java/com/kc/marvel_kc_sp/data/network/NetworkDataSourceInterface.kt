package com.kc.marvel_kc_sp.data.network

import com.kc.marvel_kc_sp.data.network.model.DataRemote
import com.kc.marvel_kc_sp.data.network.model.MarvelCharacterRemote
import com.kc.marvel_kc_sp.data.network.model.SeriesRemote
import kotlinx.coroutines.flow.Flow

interface NetworkDataSourceInterface {
    suspend fun getCharacters(page: Int): DataRemote
    suspend fun getDetails(id: Int): Flow<MarvelCharacterRemote>
    //suspend fun getSeries(id: Int): Flow<List<SeriesRemote>>
    suspend fun getSeries(id: Int, page: Int): Flow<List<SeriesRemote>>

}