package com.kc.marvel_kc_sp.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.kc.marvel_kc_sp.R
import kotlin.math.min

@Composable
fun AnimatedImage(
    image: String,
    preview: Boolean = false,
    modifier: Modifier = Modifier,
) {
    val painter = rememberAsyncImagePainter(image)
    val state = painter.state

    val transition by animateFloatAsState(
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy, stiffness = Spring.StiffnessVeryLow
        ),
        targetValue = if (state is AsyncImagePainter.State.Success || preview) 1f else 0f,
        label = "transition"
    )

    Box(
        modifier = modifier
    ) {
        if (state is AsyncImagePainter.State.Loading && !preview)
            LoadingAnimation(
                Modifier.align(Alignment.Center)
            )

        Image(
            contentScale = ContentScale.FillBounds,
            painter = if (preview) painterResource(id = R.drawable.landscape_placeholder) else painter,
            contentDescription = "custom transition based on painter state",
            modifier = Modifier
                .fillMaxSize()
                .scale(.8f + (.2f * transition))
                .graphicsLayer(rotationX = (1f - transition) * 5f)
                .alpha(min(1f, transition / .2f))
                .clip(CardDefaults.shape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedImagePreview() {
    AnimatedImage(
        image = "url",
        preview = true,
        modifier = Modifier
            .fillMaxWidth()
            //16:9 as the images requested
            .aspectRatio(1.77777777778f)
    )
}