package com.kerubyte.engage.feature.listing.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kerubyte.engage.common.ui.navigation.Screen

@Composable
fun ListingScreen(
    navController: NavController,
    listingVm: ListingViewModel = hiltViewModel()
) {
    val state by remember { listingVm.state }
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar()
        state.data?.let { listOfProducts ->
            ListingGrid(
                data = listOfProducts,
                onItemClick = { product ->
                    navController.navigate(
                        Screen.DetailScreen.withArgs(product.id)
                    )
                }
            )
        }
    }
}