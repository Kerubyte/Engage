package com.kerubyte.engage.feature.listing.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kerubyte.engage.common.util.Response
import com.kerubyte.engage.feature.listing.domain.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel
@Inject
constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {
    var state = mutableStateOf(ListingScreenState())
        private set

    fun getAllProducts() {
        viewModelScope.launch {
            state = state.copy(
                loading = true,
                error = null
            )
            state = when (val response = getAllProductsUseCase()) {
                is Response.Success -> {
                    state.copy(
                        loading = false,
                        data = response.data
                    )
                }
                is Response.Error -> {
                    state.copy(
                        loading = false,
                        data = null,
                        error = response.message
                    )
                }
            }
        }
    }
}