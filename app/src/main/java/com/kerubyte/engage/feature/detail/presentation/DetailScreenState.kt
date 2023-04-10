package com.kerubyte.engage.feature.detail.presentation

import com.kerubyte.engage.common.domain.model.Product

data class DetailScreenState(
    val isLoading: Boolean = false,
    val data: Product? = null,
    val error: String? = null
)