package com.kc.marvel_kc_sp.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import kotlin.math.min

@Composable
fun CharacterList(characters: List<ListCharacterUI>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        //items(characters) {
        items(generateCharacters(12)) {
            CharacterListItem(character = it)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 8997920)
@Composable
private fun CharacterList_Preview() {
    CharacterList(generateCharacters(10))
}

@Composable
fun CharacterListItem(character: ListCharacterUI, modifier: Modifier = Modifier) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {

            AnimatedImage(image = character.thumbnail)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = character.name, style = MaterialTheme.typography.headlineMedium)

        }
    }
}

@Preview
@Composable
private fun CharacterListItem_Preview() {
    CharacterListItem(generateCharacters(1).first())
}

@Composable
fun LoadingAnimation(modifier: Modifier = Modifier) {
    val animation = rememberInfiniteTransition(label = "loadingTransition")
    val progress by animation.animateFloat(
        initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Restart,
        ), label = "LoadingAnimation"
    )

    Box(
        modifier = modifier
            .size(60.dp)
            .scale(progress)
            .alpha(1f - progress)
            .border(
                5.dp, color = Color.Black, shape = CircleShape
            )
    )
}

// Can be previewed on the "animation preview"
@Preview(showBackground = true)
@Composable
private fun LoadingAnimation_Preview() {
    LoadingAnimation()
}

fun generateCharacters(size: Int) = (0 until size).map {
    ListCharacterUI(
        it,
        "Name $it",
        "Description $it",
        "https://i.annihil.us/u/prod/marvel/i/mg/f/80/4ce5a6d8b8f2a/landscape_incredible.jpg",
//        "https://i.annihil.us/u/prod/marvel/i/mg/1/60/52695277ee088/landscape_incredible.jpg",
        //"https://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available/landscape_incredible.jpg",
        it % 3 == 0,
        it,
    )
}


@Composable
fun AnimatedImage(image: String, modifier: Modifier = Modifier) {
    val painter = rememberAsyncImagePainter(image)
    val state = painter.state

    val transition by animateFloatAsState(
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessVeryLow
        ),
        targetValue = if (state is AsyncImagePainter.State.Success) 1f else 0f,
        label = "transition"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.77777777778f)
    ) {
        if (state is AsyncImagePainter.State.Loading)
            LoadingAnimation(Modifier.align(Alignment.Center))

        Image(
            painter = painter,
            contentDescription = "custom transition based on painter state",
            modifier = Modifier
                .fillMaxSize()
                .scale(.8f + (.2f * transition))
                .graphicsLayer(rotationX = (1f - transition) * 5f)
                .alpha(min(1f, transition / .2f))
        )
    }
}