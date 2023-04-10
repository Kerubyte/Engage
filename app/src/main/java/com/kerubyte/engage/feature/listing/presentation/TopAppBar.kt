package com.kerubyte.engage.feature.listing.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.Menu, contentDescription = null)
        }
        AppTitle(stringRes = "Engage.")
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = null)
        }
    }
}

@Composable
private fun AppTitle(stringRes: String) {
    Text(
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
        text = stringRes
    )
}