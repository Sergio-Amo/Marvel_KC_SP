package com.kc.marvel_kc_sp.data.mappers

import com.kc.marvel_kc_sp.data.network.model.MarvelCharacterRemote
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.utils.urlUpgrade
import javax.inject.Inject

class RemoteToListCharacterUI @Inject constructor() {
    fun map(remote: List<MarvelCharacterRemote>, page: Int): List<ListCharacterUI> {
        return remote.map { remote ->
            val url = urlUpgrade(
                "${remote.thumbnail.path}/landscape_incredible.${remote.thumbnail.extension}"
            )
            ListCharacterUI(
                id = remote.id,
                name = remote.name,
                description = remote.description,
                thumbnail = url,
                favorite = false,
                page = page
            )
        }
    }
}