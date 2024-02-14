package com.kc.marvel_kc_sp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable(RootScreen.CharactersList.route){

        }
    }
}

private fun NavController.navigateToDetail(
    root: RootScreen,
    characterId: Long
) {
    navigate(Screen.CharacterDetails.createRoute(root, characterId))
}

internal sealed class RootScreen(val route: String) {
    data object CharactersList : RootScreen("list")
}


private sealed class Screen(
    private val route: String,
) {
    fun createRoute(root: RootScreen) = "${root.route}/$route"

    data object Discover : Screen("list")

    data object CharacterDetails : Screen("details/{characterId}") {
        fun createRoute(root: RootScreen, characterId: Long): String {
            return "${root.route}/details/$characterId"
        }
    }
}

