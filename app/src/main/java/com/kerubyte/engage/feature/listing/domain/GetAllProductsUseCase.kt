package com.kerubyte.engage.feature.listing.domain

import android.util.Log
import com.kerubyte.engage.common.domain.data.ProductRepository
import com.kerubyte.engage.common.domain.model.Product
import com.kerubyte.engage.common.util.Response
import com.kerubyte.engage.common.util.RootUseCase
import javax.inject.Inject

class GetAllProductsUseCase
@Inject constructor(
    private val productRepository: ProductRepository
) : RootUseCase<Any, List<Product>> {
    override suspend fun invoke(input: Any?): Response<List<Product>> {
        val response = productRepository.getAllProducts()
        return when {
            response.isNullOrEmpty() -> {
                Response.Error.NetworkError(message = "Smth went wrong, veri wrong")
            }
            else -> {
                Response.Success(data = response)
            }
        }
    }
}