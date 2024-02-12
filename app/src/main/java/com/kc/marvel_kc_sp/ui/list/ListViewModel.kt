package com.kc.marvel_kc_sp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kc.marvel_kc_sp.data.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: RepositoryImpl,
) : ViewModel() {
    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCharacters()
        }
    }

    init {

    }
}