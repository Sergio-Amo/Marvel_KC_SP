package com.kc.marvel_kc_sp.data.network

import com.kc.marvel_kc_sp.data.network.api.MarvelApi
import com.kc.marvel_kc_sp.data.network.model.DataRemote
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(private val api: MarvelApi) :
    NetworkDataSourceInterface {

    private val limit = 20
    override suspend fun getCharacters(page: Int): DataRemote =
        api.getCharacters(limit, limit * (page - 1)).data

}