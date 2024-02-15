package com.kc.marvel_kc_sp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kc.marvel_kc_sp.data.RepositoryInterface
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.domain.model.SeriesUI
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

    private val _seriesFlow: MutableStateFlow<List<SeriesUI>> = MutableStateFlow(emptyList())
    val seriesFlow: StateFlow<List<SeriesUI>> = _seriesFlow.asStateFlow()

    fun getFlows(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            // get details
            repository.getDetailsFlow(id).collect { character ->
                _detailsFlow.update { character }
            }
            // get series
            repository.getSeriesFlow(id).collect { series ->
                _seriesFlow.update { series }
            }
        }
    }
}