package com.kc.marvel_kc_sp.data.mappers

import com.kc.marvel_kc_sp.data.network.model.MarvelCharacterRemote
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.utils.urlUpgrade
import javax.inject.Inject

class RemoteToListCharacterUI @Inject constructor() {
    fun map(remote: List<MarvelCharacterRemote>, page: Int): List<ListCharacterUI> {
        return remote.map { remote ->
            ListCharacterUI(
                id = remote.id,
                name = remote.name,
                description = remote.description,
                thumbnail = finalUrl(remote.thumbnail.path, remote.thumbnail.extension),
                favorite = false,
                page = page
            )
        }
    }

    private fun finalUrl(path: String, extension: String): String {
        val landscapeRoute = "/landscape_incredible"
        return urlUpgrade("$path$landscapeRoute.$extension")
    }
    fun single(remote: MarvelCharacterRemote, page: Int = -1): ListCharacterUI {
        return ListCharacterUI(
            id = remote.id,
            name = remote.name,
            description = remote.description,
            thumbnail = finalUrl(remote.thumbnail.path, remote.thumbnail.extension),
            favorite = false,
            page = page
        )
    }
}

