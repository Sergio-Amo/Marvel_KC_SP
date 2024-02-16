package com.kc.marvel_kc_sp

import java.security.MessageDigest

object Authentication {

    private const val publicKey: String = "04a35daeb98aacc066494b71b51b19d3"
    private const val privateKey: String = "faa47bd08fdae0a294f9aba563e69fdfc965d8e0"

    val authenticationParams: AuthQueryParams get() {
        val timeStamp = System.currentTimeMillis().toString()
        val hash = stringToMd5("$timeStamp$privateKey$publicKey")
        return AuthQueryParams(publicKey, timeStamp, hash)
        //"apikey=$publicKey&ts=$timeStamp&hash=$hash"
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun stringToMd5(value: String): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(value.toByteArray())
        return digest.toHexString()
    }

}

data class AuthQueryParams (
    val apikey: String,
    val timeStamp: String,
    val hash: String,
)