package com.kc.marvel_kc_sp.data

import com.kc.marvel_kc_sp.data.network.NetworkDataSourceInterface
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.utils.urlUpgrade
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    // private val localDataSource: LocalDataSourceInterface,
    private val networkDataSource: NetworkDataSourceInterface,
) : RepositoryInterface {
    override suspend fun getCharactersLocal()/*: Flow<List<ListCharacterLocal>>*/ {
        //val nwCharacters = networkDataSource.getCharacters()
        // TODO
    }

    override suspend fun getCharactersRemote(): Flow<List<ListCharacterUI>> {
        //val nwCharacters = networkDataSource.getCharacters()
        val remote = networkDataSource.getCharacters()


        // TODO MOVE THIS TO A MAPPER
        var position = remote.offset - 1
        val local = remote.results.map { remote ->
            val url = urlUpgrade(
                "${remote.thumbnail.path}/landscape_incredible.${remote.thumbnail.extension}"
            )
            position++
            ListCharacterUI(
                id = remote.id,
                name = remote.name,
                description = remote.description,
                thumbnail = url,
                favorite = false,
                position = position
            )
        }
        // TODO MOVE THIS TO A MAPPER
        return listOf(local).asFlow()
    }
}