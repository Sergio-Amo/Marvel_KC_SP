package com.kc.marvel_kc_sp.data

import android.util.Log
import com.kc.marvel_kc_sp.data.network.NetworkDataSourceInterface
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    // private val localDataSource: LocalDataSourceInterface,
    private val networkDataSource: NetworkDataSourceInterface,
) : RepositoryInterface {
    override suspend fun getCharacters() {
        val nwCharacters = networkDataSource.getCharacters()
        nwCharacters.results.forEach {
            Log.d("CHARS", it.name)
        }
    }
}