package com.kc.marvel_kc_sp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kc.marvel_kc_sp.ui.components.CharacterList
import com.kc.marvel_kc_sp.ui.components.generateCharacters
import com.kc.marvel_kc_sp.ui.list.ListViewModel
import com.kc.marvel_kc_sp.ui.theme.Marvel_KC_SPTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val listViewModel: ListViewModel by viewModels()

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
                    CharacterList(characters = generateCharacters(12))
                    //NavigationController()
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
