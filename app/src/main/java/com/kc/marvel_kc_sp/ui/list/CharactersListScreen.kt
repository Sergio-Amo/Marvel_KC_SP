package com.kc.marvel_kc_sp.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.ui.components.CharacterListItem
import com.kc.marvel_kc_sp.ui.components.MarvelBar
import com.kc.marvel_kc_sp.utils.CharacterMocks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CharactersListScreen(viewModel: ListViewModel = hiltViewModel()) {
    val characters by viewModel.roomFlow.collectAsState()
    val scope = rememberCoroutineScope()

    CharacterList(characters = characters, totalItems = characters.size, clearDB = {
        scope.launch(Dispatchers.IO){
            viewModel.clearDB()
        }
    }) {
        viewModel.getCharacters()
    }
}

@Composable
fun CharacterList(
    characters: List<ListCharacterUI>,
    preview: Boolean = false,
    totalItems: Int,
    modifier: Modifier = Modifier,
    clearDB: () -> Unit,
    loadNextPage: () -> Unit,
) {

    val listState = rememberLazyListState()

    Scaffold(topBar = {
        MarvelBar(clearDB)
    }) { padding ->
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier
                .padding(padding)
                .background(Color.White)
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(totalItems) { idx ->
                CharacterListItem(character = characters[idx], preview = preview)
                if (idx == totalItems - 5)
                    loadNextPage()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterList_Preview() {
    CharacterList(
        CharacterMocks.generateCharactersUI(12),
        preview = true,
        totalItems = 12,
        clearDB = {}
    ) {}
}