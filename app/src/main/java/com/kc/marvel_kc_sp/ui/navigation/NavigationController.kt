package com.kc.marvel_kc_sp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kc.marvel_kc_sp.ui.details.CharacterDetailScreen
import com.kc.marvel_kc_sp.ui.list.CharactersListScreen

@Composable
fun NavigationController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.List.route) {
        composable(Screen.List.route) {
            CharactersListScreen {
                navController.navigate(Screen.Details.createRoute(it))
            }
        }

        composable(
            Screen.Details.createRoute(), arguments = listOf(navArgument("id") {
                this.type = NavType.IntType
                nullable = false
                defaultValue = 1009146
            })
        ) {
            it.arguments?.getInt("id")?.let {
                CharacterDetailScreen(it)
            }
        }
    }
}

internal sealed class Screen(val route: String) {
    object List : Screen("characterslist")
    object Details : Screen("characterdetail") {
        fun createRoute(id: Int? = null): String {
            return if (id != null) "${this.route}/$id"
            else "${this.route}/{id}"
        }
    }
}