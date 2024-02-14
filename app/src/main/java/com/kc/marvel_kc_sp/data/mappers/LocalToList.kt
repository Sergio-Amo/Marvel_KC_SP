package com.kc.marvel_kc_sp.data.mappers

import com.kc.marvel_kc_sp.data.local.model.ListCharacterLocal
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import javax.inject.Inject

class LocalToList @Inject constructor() {
    fun map(local: List<ListCharacterLocal>): List<ListCharacterUI> {
        return local.map { local ->
            ListCharacterUI(
                id = local.id,
                name = local.name,
                description = local.description,
                thumbnail = local.thumbnail,
                favorite = local.favorite,
                page = local.page
            )
        }
    }
}