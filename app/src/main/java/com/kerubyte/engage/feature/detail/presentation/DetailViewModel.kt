package com.kerubyte.engage.feature.detail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kerubyte.engage.common.util.Constants.PRODUCT_ID
import com.kerubyte.engage.common.util.Response
import com.kerubyte.engage.feature.detail.domain.GetProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getProductByIdUseCase: GetProductByIdUseCase
) : ViewModel() {
    var state by mutableStateOf(DetailScreenState())
        private set

    fun getSingleProduct() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            state = when (val response =
                getProductByIdUseCase(savedStateHandle.get<Int>(PRODUCT_ID))) {
                is Response.Success -> {
                    state.copy(
                        isLoading = false,
                        data = response.data,
                        error = null
                    )
                }
                is Response.Error -> {
                    state.copy(
                        isLoading = false,
                        error = response.message
                    )
                }
            }
        }
    }
}