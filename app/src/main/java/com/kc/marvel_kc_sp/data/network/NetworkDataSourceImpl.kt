package com.kc.marvel_kc_sp.data.network

import com.kc.marvel_kc_sp.data.network.api.MarvelApi
import com.kc.marvel_kc_sp.data.network.model.DataRemote
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(private val api: MarvelApi): NetworkDataSourceInterface {
    override suspend fun getCharacters(): DataRemote = api.getCharacters(20,0).data

}