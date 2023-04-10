package com.kerubyte.engage.feature.detail.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun DetailScreen(
    navController: NavController,
    detailVm: DetailViewModel = hiltViewModel()
) {
    detailVm.getSingleProduct()
    val state = detailVm.state
    state.data?.let {
        Text(text = it.name)
    }

}