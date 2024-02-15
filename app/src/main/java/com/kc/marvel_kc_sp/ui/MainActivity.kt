package com.kc.marvel_kc_sp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kc.marvel_kc_sp.ui.details.CharacterDetailScreen
import com.kc.marvel_kc_sp.ui.list.CharactersListScreen
import com.kc.marvel_kc_sp.ui.theme.Marvel_KC_SPTheme
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


                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "characterslist") {
                        composable("characterslist") {
                            CharactersListScreen(navigateToDetail = {
                                navController.navigate("characterdetail/$it")
                            })
                        }

                        composable(
                            "characterdetail/{id}",
                            arguments = listOf(navArgument("id") {
                                this.type = NavType.IntType
                                nullable = false
                                defaultValue = 1009146
                            })
                        ) {
                            it.arguments?.getInt("id")?.let { id ->
                                CharacterDetailScreen(id)
                            }
                        }
                    }


                }
            }
        }
    }
}
