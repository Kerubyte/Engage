package com.kerubyte.engage.feature.listing.presentation

import com.kerubyte.engage.common.domain.model.Product

data class ListingScreenState(
    val loading: Boolean = false,
    val data: List<Product>? = null,
    val error: String? = null
)
