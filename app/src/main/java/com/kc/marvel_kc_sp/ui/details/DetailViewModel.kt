package com.kc.marvel_kc_sp.ui.details

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
class DetailViewModel @Inject constructor(
    private val repository: RepositoryInterface
) : ViewModel() {

    private val _detailsFlow: MutableStateFlow<ListCharacterUI> =
        MutableStateFlow(ListCharacterUI(-1, "", "", "", false, -1))
    val detailsFlow: StateFlow<ListCharacterUI> = _detailsFlow.asStateFlow()

//    private val _seriesFlow: MutableStateFlow<List<ListSeriesUI>> = MutableStateFlow(emptyList())
//    val favFlow: StateFlow<List<ListSeriesUI>> = _seriesFlow.asStateFlow()

   /* init {
        getDetailsFlow()
        getSeriesFlow()
    }*/

    fun getDetailsFlow(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDetailsFlow(id).collect { character ->
                _detailsFlow.update { character }
            }
        }
    }

    private fun getSeriesFlow() {

    }

}