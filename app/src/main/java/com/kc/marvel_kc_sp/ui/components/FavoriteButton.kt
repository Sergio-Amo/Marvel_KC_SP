package com.kc.marvel_kc_sp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

// TODO: refactor and use this?

@Composable
fun FavoriteButton(modifier: Modifier = Modifier) {
    Icon(Icons.Filled.Favorite, contentDescription = "Favorite", modifier = modifier, tint = Color.White)
}

@Preview
@Composable
private fun NotFavoriteButton_Preview() {
    FavoriteButton()
}

@Composable
fun NotFavoriteButton(modifier: Modifier = Modifier) {
    Icon(Icons.Filled.FavoriteBorder, contentDescription = "NotFavorite", modifier = modifier, tint = Color.White)
}

@Preview
@Composable
private fun FavoriteButton_Preview() {
    NotFavoriteButton()
}