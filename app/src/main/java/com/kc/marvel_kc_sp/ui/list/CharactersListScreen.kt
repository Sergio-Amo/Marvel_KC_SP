package com.kc.marvel_kc_sp.ui.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.kc.marvel_kc_sp.ui.components.LazyRowFavCharacters
import com.kc.marvel_kc_sp.ui.components.MarvelBar
import com.kc.marvel_kc_sp.utils.CharacterMocks
import com.kc.marvel_kc_sp.utils.fillWidthOfParent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CharactersListScreen(viewModel: ListViewModel = hiltViewModel()) {
    val characters by viewModel.roomFlow.collectAsState()
    val favorites by viewModel.favFlow.collectAsState()
    val scope = rememberCoroutineScope()

    CharacterList(
        characters = characters,
        favorites = favorites,
        totalItems = characters.size,
        clearDB = {
            scope.launch(Dispatchers.IO) {
                viewModel.clearDB()
                viewModel.loadMore(0)
            }
        },
        favorite = {
            scope.launch(Dispatchers.IO) {
                viewModel.favorite(it)
            }
        },
        navigateToDetail = {
            Log.d("SDAR", "id: $it")
        }
    ) {
        viewModel.loadMore(characters.last().page)
    }
}

@Composable
fun CharacterList(
    characters: List<ListCharacterUI>,
    favorites: List<ListCharacterUI>,
    preview: Boolean = false,
    totalItems: Int,
    modifier: Modifier = Modifier,
    clearDB: () -> Unit,
    favorite: (id: Int) -> Unit,
    navigateToDetail: (id: Int) -> Unit,
    loadNextPage: () -> Unit,
) {

    val listState = rememberLazyListState()

    Scaffold(topBar = {
        MarvelBar(clearDB)
    }) { padding ->
        Column {
            val scaffoldPadding = if (favorites.isEmpty()) padding else PaddingValues(0.dp)
            LazyColumn(
                state = listState,
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier
                    .padding(scaffoldPadding)
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(8.dp, 0.dp)
            ) {
                if (favorites.isNotEmpty()) {
                    item {
                        LazyRowFavCharacters(
                            characters = favorites,
                            preview = preview,
                            modifier = Modifier
                                .fillWidthOfParent(8.dp)
                                .padding(padding)
                        )
                    }
                } else {
                    item {
                        Spacer(modifier = Modifier.height(0.dp))
                    }
                }
                items(totalItems) { idx ->
                    CharacterListItem(
                        character = characters[idx],
                        preview = preview,
                        navigateToDetail = {
                            navigateToDetail(it)
                        },
                    ) { id ->
                        favorite(id)
                    }
                    if (idx == totalItems - 5)
                        loadNextPage()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CharacterList_Preview() {
    CharacterList(
        CharacterMocks.generateCharactersUI(12),
        favorites = CharacterMocks.generateCharactersUI(12).filter { it.favorite },
        preview = true,
        totalItems = 12,
        clearDB = {},
        favorite = {},
        navigateToDetail = {},
    ) {}
}