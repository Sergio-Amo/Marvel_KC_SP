package com.kc.marvel_kc_sp.data.network

import com.kc.marvel_kc_sp.data.network.model.DataRemote

interface NetworkDataSourceInterface {
    suspend fun getCharacters(): DataRemote
}