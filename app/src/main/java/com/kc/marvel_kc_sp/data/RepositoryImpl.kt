package com.kc.marvel_kc_sp.data

import com.kc.marvel_kc_sp.data.local.LocalDataSourceInterface
import com.kc.marvel_kc_sp.data.mappers.RemoteToListCharacterUI
import com.kc.marvel_kc_sp.data.network.NetworkDataSourceInterface
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSourceInterface,
    private val networkDataSource: NetworkDataSourceInterface,
    private val remoteToListCharacterUI: RemoteToListCharacterUI,
) : RepositoryInterface {

    override suspend fun getCharacters(page: Int): Flow<List<ListCharacterUI>> {
        val remote = networkDataSource.getCharacters(page)
        return listOf(remoteToListCharacterUI.map(remote.results, page)).asFlow()
    }
}