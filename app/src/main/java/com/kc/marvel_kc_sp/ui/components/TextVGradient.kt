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
fun TextBottomVGradient(text: String = "", modifier: Modifier = Modifier) {
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
                    .42F to Color.Black.copy(alpha = 0.6F),
                    1F to Color.Black.copy(alpha = 0.8F)
                )
            )
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 32.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun TextBottomVGradient_Preview() {
    TextBottomVGradient("Some very long character name")
}

@Composable
fun TextTopVGradient(text: String = "", modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        color = Color.White,
        modifier = modifier
            .fillMaxWidth()
            //.align(Alignment.BottomStart)
            .background(
                Brush.verticalGradient(
                    0F to Color.Black.copy(alpha = 0.8F),
                    .58F to Color.Black.copy(alpha = 0.6F),
                    1F to Color.Transparent
                )
            )
            .padding(start = 8.dp, end = 8.dp, bottom = 32.dp, top = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun TextTopVGradient_Preview() {
    TextTopVGradient("Some very long character name")
}