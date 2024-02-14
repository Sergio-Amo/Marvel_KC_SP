package com.kc.marvel_kc_sp.utils

import java.net.URL

fun urlUpgrade(original: String): String {
    val url = URL(original)
    return if (url.protocol == "http")
        URL("https", url.host, url.file).toString()
    else original
}
