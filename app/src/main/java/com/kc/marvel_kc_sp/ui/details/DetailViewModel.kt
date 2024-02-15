package com.kc.marvel_kc_sp.ui.details

import androidx.lifecycle.ViewModel
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {

    private val _detailsFlow: MutableStateFlow<ListCharacterUI> =
        MutableStateFlow(ListCharacterUI(-1, "", "", "", false, -1))
    val detailsFlow: StateFlow<ListCharacterUI> = _detailsFlow.asStateFlow()

//    private val _seriesFlow: MutableStateFlow<List<ListSeriesUI>> = MutableStateFlow(emptyList())
//    val favFlow: StateFlow<List<ListSeriesUI>> = _seriesFlow.asStateFlow()

    init {
        getDetailsFlow()
        getSeriesFlow()
    }

    private fun getDetailsFlow() {

    }

    private fun getSeriesFlow() {

    }

}