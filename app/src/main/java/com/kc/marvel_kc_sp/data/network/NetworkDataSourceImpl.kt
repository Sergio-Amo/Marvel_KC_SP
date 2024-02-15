package com.kc.marvel_kc_sp.data.network

import com.kc.marvel_kc_sp.data.network.api.MarvelApi
import com.kc.marvel_kc_sp.data.network.model.DataRemote
import com.kc.marvel_kc_sp.data.network.model.MarvelCharacterRemote
import com.kc.marvel_kc_sp.data.network.model.SeriesRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(private val api: MarvelApi) :
    NetworkDataSourceInterface {

    private val limit = 20
    override suspend fun getCharacters(page: Int): DataRemote =
        api.getCharacters(limit, limit * (page - 1)).data

    override suspend fun getDetails(id: Int): Flow<MarvelCharacterRemote> {
        return flowOf(api.getDetails(id).data.results.first())
    }

    override suspend fun getSeries(id: Int): Flow<List<SeriesRemote>> {
        return flowOf(api.getSeries(id).data.results)
    }
}