package com.kc.marvel_kc_sp.data

import com.kc.marvel_kc_sp.data.local.FakeLocalDataSource
import com.kc.marvel_kc_sp.data.local.LocalDataSourceInterface
import com.kc.marvel_kc_sp.data.local.model.ListCharacterLocal
import com.kc.marvel_kc_sp.data.mappers.LocalToList
import com.kc.marvel_kc_sp.data.mappers.RemoteToListCharacterUI
import com.kc.marvel_kc_sp.data.mappers.RemoteToLocal
import com.kc.marvel_kc_sp.data.mappers.SeriesRemoteToUI
import com.kc.marvel_kc_sp.data.network.NetworkDataSourceInterface
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RepositoryImplFakeTest {

    // SUT
    private lateinit var repository: RepositoryImpl

    private val localDataSource: LocalDataSourceInterface = FakeLocalDataSource()
    private val networkDataSource: NetworkDataSourceInterface = mockk()
    private val remoteToLocal: RemoteToLocal = RemoteToLocal()
    private val localToList: LocalToList = LocalToList()
    private val remoteToListCharacterUI: RemoteToListCharacterUI = RemoteToListCharacterUI()
    private val seriesRemoteToUI: SeriesRemoteToUI = SeriesRemoteToUI()


    @Before
    fun setUp() {
        repository = RepositoryImpl(
            localDataSource,
            networkDataSource,
            remoteToLocal,
            localToList,
            remoteToListCharacterUI,
            seriesRemoteToUI,
        )
    }

    // I'm in a hurry, sorry for not doing more Fakes, there's a lot more on the previous assignment
    @Test
    fun `WHEN localData RETURNS characters as flow`() = runTest {
        // Given
        val expected = listOf<ListCharacterLocal>(
            ListCharacterLocal(42, "test", "", "", false, 1)
        )

        // When
        val actual = repository.getFlow().first()

        // Then
        assertEquals(expected.first().id, actual.first().id)
    }

}

