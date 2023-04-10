package com.kerubyte.engage.common.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kerubyte.engage.common.util.Constants.PRODUCT_ID
import com.kerubyte.engage.feature.detail.presentation.DetailScreen
import com.kerubyte.engage.feature.listing.presentation.ListingScreen

@Composable
fun NavigationController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ListingScreen.route) {
        composable(
            Screen.ListingScreen.route
        ) {
            ListingScreen(
                navController = navController
            )
        }
        composable(
            Screen.DetailScreen.route + "/{$PRODUCT_ID}",
            arguments = listOf(
                navArgument(PRODUCT_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            DetailScreen(
                navController = navController
            )
        }
    }
}