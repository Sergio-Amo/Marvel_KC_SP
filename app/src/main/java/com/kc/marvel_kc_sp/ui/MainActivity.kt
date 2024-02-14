package com.kc.marvel_kc_sp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kc.marvel_kc_sp.ui.theme.Marvel_KC_SPTheme
import com.kc.marvel_kc_sp.ui.ui.list.HeroesListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Marvel_KC_SPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MainScreen(viewModel = listViewModel)
                    //CharacterList(characters = generateCharacters(100))
                    //NavigationController()
                    HeroesListScreen()
                }
            }
        }
    }
}
/*
@Composable
fun MainScreen(viewModel: ListViewModel) {
    Text(
        text = "Hello!"
    )
    viewModel.getCharacters()
}
*/
