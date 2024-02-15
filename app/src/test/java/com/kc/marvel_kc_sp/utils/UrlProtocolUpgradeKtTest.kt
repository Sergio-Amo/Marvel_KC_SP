package com.kc.marvel_kc_sp.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.net.URL

class UrlProtocolUpgradeKtTest {


    // I'm in a hurry, sorry for not doing more unit tests, there's a lot more on the previous assignment
    @Test
    fun `GIVEN http url THEN https url`() {

        val http = "http://some.url.com"
        val expected = "https://some.url.com"
        val actual = urlUpgrade(http)

        assertEquals(expected, actual)
        assertTrue(URL(actual).protocol == "https")
    }
}