package com.kc.marvel_kc_sp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kc.marvel_kc_sp.data.RepositoryInterface
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: RepositoryInterface,
) : ViewModel() {

    private val _roomFlow: MutableStateFlow<List<ListCharacterUI>> = MutableStateFlow(emptyList())
    val roomFlow: StateFlow<List<ListCharacterUI>> = _roomFlow.asStateFlow()

    private var page: Int = 0

    init {
        getCharacters()
    }

    fun getCharacters() {
        page++
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCharacters(page).collect { characters ->
                _roomFlow.update {
                    it + characters
                }
            }
//            page++
        }
    }

    suspend fun clearDB() {
        repository.deleteDb()
    }
}