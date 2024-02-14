package com.kc.marvel_kc_sp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextVGradient(text: String = "", modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        color = Color.White,
        modifier = modifier
            .fillMaxWidth()
            //.align(Alignment.BottomStart)
            .background(
                Brush.verticalGradient(
                    0F to Color.Transparent,
                    .5F to Color.Black.copy(alpha = 0.6F),
                    1F to Color.Black.copy(alpha = 0.8F)
                )
            )
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 28.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun TextVGradient_Preview() {
    TextVGradient("Some character name")
}