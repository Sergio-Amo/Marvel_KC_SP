@file:OptIn(ExperimentalMaterial3Api::class)

package com.kc.marvel_kc_sp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kc.marvel_kc_sp.ui.theme.MarvelRed
import com.kc.marvel_kc_sp.ui.theme.marvel

@Composable
fun MarvelBar(clearDB: () -> Unit, modifier: Modifier = Modifier) {
    var openMenu by remember { mutableStateOf(false) }
    CenterAlignedTopAppBar(title = {
        Text(
            text = "MARVEL", style = TextStyle(
                fontFamily = marvel,
                color = Color.White,
                fontSize = 36.sp,
            ),modifier = Modifier.padding(0.dp,6.dp,0.dp,0.dp)
        )
    }, actions = {
        IconButton(onClick = { openMenu = true }) {
            Icon(Icons.Filled.MoreVert, contentDescription = "Localized description", tint = Color.White)
        }
        DropdownMenu(expanded = openMenu, onDismissRequest = { openMenu = false }) {
            DropdownMenuItem(text = { Text("Clear saved data") }, onClick = {
                clearDB()
                openMenu = false
            })
        }

    }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MarvelRed)
    )
}

@Preview
@Composable
private fun MarvelBar_Preview() {
    MarvelBar({})
}