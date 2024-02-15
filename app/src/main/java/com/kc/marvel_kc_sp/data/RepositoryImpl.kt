package com.kc.marvel_kc_sp.data

import com.kc.marvel_kc_sp.data.local.LocalDataSourceInterface
import com.kc.marvel_kc_sp.data.mappers.LocalToList
import com.kc.marvel_kc_sp.data.mappers.RemoteToListCharacterUI
import com.kc.marvel_kc_sp.data.mappers.RemoteToLocal
import com.kc.marvel_kc_sp.data.mappers.SeriesRemoteToUI
import com.kc.marvel_kc_sp.data.network.NetworkDataSourceInterface
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.domain.model.SeriesUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSourceInterface,
    private val networkDataSource: NetworkDataSourceInterface,
    private val remoteToLocal: RemoteToLocal,
    private val localToList: LocalToList,
    private val remoteToListCharacterUI: RemoteToListCharacterUI,
    private val seriesRemoteToUI: SeriesRemoteToUI,
) : RepositoryInterface {

    override suspend fun loadMore(page: Int) {
        if (!localDataSource.isStorageUsed(page)) {
            val remote = networkDataSource.getCharacters(page).results
            localDataSource.saveCharacters(
                remoteToLocal.map(remote, page)
            )
        }
    }

    override suspend fun favorite(id: Int) {
        localDataSource.toggleFavorite(id)
    }

    override suspend fun deleteDb() {
        localDataSource.deleteCharacters()
    }

    override suspend fun getFlow(): Flow<List<ListCharacterUI>> {
        if (!localDataSource.isStorageUsed(1)) {
            val remote = networkDataSource.getCharacters(1)
            localDataSource.saveCharacters(remoteToLocal.map(remote.results, 1))
        }
        return localDataSource.getAllCharacters().map {
            localToList.map(it)
        }
    }

    override suspend fun getFavoriteFlow(): Flow<List<ListCharacterUI>> {
        return localDataSource.getFavoriteCharacters().map { localToList.map(it) }
    }

    override suspend fun getDetailsFlow(id: Int): Flow<ListCharacterUI> {
        return networkDataSource.getDetails(id).map {
            remoteToListCharacterUI.single(it, -1)
        }
    }

    override suspend fun getSeriesFlow(id: Int, page: Int): Flow<List<SeriesUI>> {
        return networkDataSource.getSeries(id, page).map {
            seriesRemoteToUI.map(it, page)
        }
    }
}