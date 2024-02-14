package com.kc.marvel_kc_sp.data

import com.kc.marvel_kc_sp.data.local.LocalDataSourceInterface
import com.kc.marvel_kc_sp.data.mappers.LocalToList
import com.kc.marvel_kc_sp.data.mappers.RemoteToLocal
import com.kc.marvel_kc_sp.data.network.NetworkDataSourceInterface
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSourceInterface,
    private val networkDataSource: NetworkDataSourceInterface,
    private val remoteToLocal: RemoteToLocal,
    private val localToList: LocalToList,
) : RepositoryInterface {

    override suspend fun getCharacters(page: Int): Flow<List<ListCharacterUI>> {
        return if (localDataSource.isStorageUsed()) {
            localDataSource.getCharacters(page).map { localToList.map(it) }
        } else {
            val remote = networkDataSource.getCharacters(page)
            localDataSource.saveCharacters(remoteToLocal.map(remote.results, page))
            localDataSource.getCharacters(page).map { localToList.map(it) }
        }
    }
}