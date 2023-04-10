package com.kerubyte.engage.feature.detail.domain

import com.kerubyte.engage.common.domain.data.ProductRepository
import com.kerubyte.engage.common.domain.model.Product
import com.kerubyte.engage.common.util.Response
import com.kerubyte.engage.common.util.RootUseCase
import javax.inject.Inject

class GetProductByIdUseCase
@Inject constructor(
    private val productRepository: ProductRepository
) : RootUseCase<Int, Product> {
    override suspend fun invoke(input: Int?): Response<Product> {
        if (input != null) {
            return when (val result = productRepository.getProductById(input)) {
                null -> Response.Error.NetworkError(
                    message = "Couldnt find product"
                )
                else -> Response.Success(
                    data = result
                )
            }
        }
        return Response.Error.BadRequestError(
            message = "Product ID cannot be null"
        )
    }
}