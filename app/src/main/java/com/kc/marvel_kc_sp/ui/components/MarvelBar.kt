@file:OptIn(ExperimentalMaterial3Api::class)

package com.kc.marvel_kc_sp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kc.marvel_kc_sp.ui.theme.MarvelRed
import com.kc.marvel_kc_sp.ui.theme.marvel

@Composable
fun MarvelBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = "MARVEL",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = marvel,
                color = Color.White,
                fontSize = 36.sp
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MarvelRed))
}

@Preview
@Composable
private fun MarvelBar_Preview() {
    MarvelBar()
}