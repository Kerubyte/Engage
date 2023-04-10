package com.kerubyte.engage.common.domain.data

import com.kerubyte.engage.common.domain.model.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>?
    suspend fun getProductById(id: Int): Product?
}