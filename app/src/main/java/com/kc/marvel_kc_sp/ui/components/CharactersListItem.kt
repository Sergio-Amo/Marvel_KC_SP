package com.kc.marvel_kc_sp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.ui.list.generateCharacters


@Composable
fun CharacterListItem(
    character: ListCharacterUI,
    preview: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            //16:9 as the images requested
            .aspectRatio(1.77777777778f)
    ) {
        Box() {
            AnimatedImage(
                image = character.thumbnail, preview = preview, modifier = Modifier
                    .fillMaxSize()
                    .clip(CardDefaults.shape)
            )

            TextBottomVGradient("${character.name} p:${character.page}", Modifier.align(Alignment.BottomStart))

            IconButton(
                modifier = Modifier

                    .background(
                        Brush.radialGradient(
                            colors = listOf(Color.Black.copy(alpha = 0.4f), Color.Transparent),
                            center = Offset(230f, 0f),
                            radius = 150f
                        )
                    )
                    .padding(40.dp, 0.dp, 0.dp, 40.dp)
                    .align(Alignment.TopEnd),
                onClick = {
                    // DoOnClick
                }) {
                if (character.favorite) {
                    Icon(
                        painter = rememberVectorPainter(Icons.Filled.Favorite),
                        contentDescription = "Favorite",
                        tint = Color.White,
                    )
                } else {
                    Icon(
                        painter = rememberVectorPainter(Icons.Filled.FavoriteBorder),
                        contentDescription = "Not favorite",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CharacterListItem_Preview() {
    CharacterListItem(generateCharacters(1).first(), preview = true)
}