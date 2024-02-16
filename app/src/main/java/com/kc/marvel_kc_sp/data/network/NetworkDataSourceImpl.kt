package com.kc.marvel_kc_sp.data.network

import com.kc.marvel_kc_sp.data.network.api.MarvelApi
import com.kc.marvel_kc_sp.data.network.model.DataRemote
import com.kc.marvel_kc_sp.data.network.model.MarvelCharacterRemote
import com.kc.marvel_kc_sp.data.network.model.SeriesRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    override suspend fun getSeries(id: Int, page: Int): Flow<List<SeriesRemote>> {
        return flow {
            var close = false
            val series = api.getSeries(id, limit, limit * (page - 1)).data
            if (!close) {
                emit(series.results)
            }
            if (series.offset + series.count < series.total) close = true
        }
    }
}