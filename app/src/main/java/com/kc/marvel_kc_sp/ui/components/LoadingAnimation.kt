package com.kc.marvel_kc_sp.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


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

// To preview use preview animation, set loop to true and play
@Preview(showBackground = true)
@Composable
private fun LoadingAnimation_Preview() {
    LoadingAnimation()
}