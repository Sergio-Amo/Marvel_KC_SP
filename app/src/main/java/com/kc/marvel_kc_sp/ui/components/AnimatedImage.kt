package com.kc.marvel_kc_sp.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            painter = if (preview) painterResource(id = R.drawable.landscape_placeholder) else painter,
            contentDescription = "custom transition based on painter state",
            modifier = Modifier
                .fillMaxSize()
                .scale(.8f + (.2f * transition))
                .graphicsLayer(rotationX = (1f - transition) * 5f)
                .alpha(min(1f, transition / .2f))
        )
        Text(
            text = character.name,
            style = MaterialTheme.typography.headlineMedium, color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .background(
                    Brush.verticalGradient(
                        0F to Color.Transparent,
                        .5F to Color.Black.copy(alpha = 0.6F),
                        1F to Color.Black.copy(alpha = 0.8F)
                    )
                )
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 24.dp)
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