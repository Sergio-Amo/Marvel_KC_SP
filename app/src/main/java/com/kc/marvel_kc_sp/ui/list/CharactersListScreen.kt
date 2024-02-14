package com.kc.marvel_kc_sp.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.ui.components.CharacterListItem

@Composable
fun CharactersListScreen(viewModel: ListViewModel = hiltViewModel()) {
    val characters by viewModel.roomFlow.collectAsState()

    CharacterList(characters = characters, totalItems = characters.size) {
        viewModel.getCharacters()
    }
}

@Composable
fun CharacterList(
    characters: List<ListCharacterUI>,
    preview: Boolean = false,
    totalItems: Int,
    modifier: Modifier = Modifier,
    loadNextPage: () -> Unit,
) {

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(totalItems) { idx ->
            CharacterListItem(character = characters[idx], preview = preview)
            if (idx == totalItems - 2)
                loadNextPage()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterList_Preview() {
    CharacterList(
        generateCharacters(12),
        preview = true,
        totalItems = generateCharacters(12).size
    ) {}
}

// TODO: move this to an external mock object
fun generateCharacters(size: Int) = (0 until size).map {
    ListCharacterUI(
        it,
        "A marvel character name $it",
        "Description $it",
        "https://i.annihil.us/u/prod/marvel/i/mg/f/80/4ce5a6d8b8f2a/landscape_incredible.jpg",
//        "https://i.annihil.us/u/prod/marvel/i/mg/1/60/52695277ee088/landscape_incredible.jpg",
        //"https://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available/landscape_incredible.jpg",
        it % 3 == 0,
        it,
    )
}