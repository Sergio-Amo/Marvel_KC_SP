package com.kc.marvel_kc_sp.ui.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.kc.marvel_kc_sp.ui.components.CharacterList

@Composable
fun HeroesListScreen(viewModel: ListViewModel = hiltViewModel()) {
    val characters by viewModel.roomFlow.collectAsState()
    CharacterList(characters = characters)
}

@Preview
@Composable
private fun HeroesListScreen_Preview() {
    HeroesListScreen()
}