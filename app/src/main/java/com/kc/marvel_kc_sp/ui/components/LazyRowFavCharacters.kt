package com.kc.marvel_kc_sp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.utils.Mocks

@Composable
fun LazyRowFavCharacters(
    characters: List<ListCharacterUI>,
    preview: Boolean = false,
    modifier: Modifier = Modifier,
    navigateToDetail: (id: Int) -> Unit,
) {
    val state = rememberLazyListState()
    LazyRow(
        state = state,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .background(
                Brush.verticalGradient(
                    0F to Color.Black.copy(alpha = 1F),
                    1F to Color.Black.copy(alpha = 0.88F)
                )
            )
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(characters) {
            CharacterPortraitItem(it, preview = preview, navigateToDetail = navigateToDetail)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LazyRowFavCharacters_Preview() {
    LazyRowFavCharacters(Mocks.generateCharactersUI(8), true){}
}

@Composable
fun CharacterPortraitItem(
    character: ListCharacterUI,
    preview: Boolean = false,
    modifier: Modifier = Modifier,
    navigateToDetail: (id: Int) -> Unit,
) {
    Column( verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            //As the images requested
            .width(96.dp)
            .height(200.dp)
            .clickable { navigateToDetail(character.id) }
    ) {

        Card(
            elevation = CardDefaults.cardElevation(5.dp),
            modifier = Modifier
                .weight(1f)
                .aspectRatio(0.666666666667f)
        ) {
            val image = character.thumbnail.replace("landscape_incredible", "portrait_incredible")
            AnimatedImage(
                image, preview,
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(CardDefaults.shape)
                    .aspectRatio(0.666666666667f)
                    .height(200.dp)
                    .weight(0.1f)
            )
        }
        Text(
            text = character.name,
            color = Color.White,
            fontSize = 13.sp,
            minLines = 2,
            maxLines = 2,
            modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 8.dp)
        )
    }
}

@Preview
@Composable
private fun CharacterPortraitItem_Preview() {
    CharacterPortraitItem(Mocks.generateCharactersUI(1).first(), preview = true){}
}