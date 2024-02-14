package com.kc.marvel_kc_sp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI

@Composable
fun CharacterList(
    characters: List<ListCharacterUI>,
    preview: Boolean = false,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(characters) {
            CharacterListItem(character = it, preview = preview)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterList_Preview() {
    CharacterList(generateCharacters(12), preview = true)
}

@Composable
fun CharacterListItem(
    character: ListCharacterUI,
    preview: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .background(Color.Black)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AnimatedImage(
                image = character.thumbnail, preview = preview, modifier = Modifier
                    .fillMaxSize()
                    //16:9 as the images requested
                    .aspectRatio(1.77777777778f)
                    .clip(CardDefaults.shape)
            )
            Row(Modifier.fillMaxWidth()) {
                TextTopVGradient(character.name)
            }
        }
    }
}

@Preview
@Composable
private fun CharacterListItem_Preview() {
    CharacterListItem(generateCharacters(1).first(), preview = true)
}


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