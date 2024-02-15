package com.kc.marvel_kc_sp.data

import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {

    suspend fun deleteDb()
    suspend fun loadMore(page: Int)
    suspend fun favorite(id: Int)
    suspend fun getFlow(): Flow<List<ListCharacterUI>>
    suspend fun getFavoriteFlow(): Flow<List<ListCharacterUI>>
}