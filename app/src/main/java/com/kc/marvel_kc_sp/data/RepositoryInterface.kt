package com.kc.marvel_kc_sp.data

import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.domain.model.SeriesUI
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {

    suspend fun deleteDb()
    suspend fun loadMore(page: Int)
    suspend fun favorite(id: Int)
    suspend fun getFlow(): Flow<List<ListCharacterUI>>
    suspend fun getFavoriteFlow(): Flow<List<ListCharacterUI>>
    suspend fun getDetailsFlow(id: Int): Flow<ListCharacterUI>
    //suspend fun getSeriesFlow(id: Int): Flow<List<SeriesUI>>
    suspend fun getSeriesFlow(id: Int, page: Int): Flow<List<SeriesUI>>
}