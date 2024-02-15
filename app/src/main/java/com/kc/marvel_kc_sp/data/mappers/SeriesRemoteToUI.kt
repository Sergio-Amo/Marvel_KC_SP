package com.kc.marvel_kc_sp.data.mappers

import com.kc.marvel_kc_sp.data.network.model.SeriesRemote
import com.kc.marvel_kc_sp.domain.model.SeriesUI
import com.kc.marvel_kc_sp.utils.urlUpgrade
import javax.inject.Inject

class SeriesRemoteToUI @Inject constructor() {

    fun map(remote: List<SeriesRemote>) = remote.map {
        val url = urlUpgrade("${it.thumbnail.path}/portrait_incredible.${it.thumbnail.extension}")
        SeriesUI(it.id, it.title, url)
    }
}