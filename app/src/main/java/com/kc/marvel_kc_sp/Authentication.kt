package com.kc.marvel_kc_sp

import java.security.MessageDigest

object Authentication {

    private const val privateKey: String = "ENTER_PRIVATE_KEY_HERE"
    private const val publicKey: String = "ENTER_PUBLIC_KEY_HERE"
    val authenticationParams: String get() {
        val timeStamp = System.currentTimeMillis()
        val hash = stringToMd5("$timeStamp$privateKey$publicKey")
        return "apikey=$publicKey&ts=$timeStamp&hash=$hash"
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun stringToMd5(value: String): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(value.toByteArray())
        return digest.toHexString()
    }

}