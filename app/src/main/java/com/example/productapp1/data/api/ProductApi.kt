package com.example.productapp1.data.api

import com.example.productapp1.data.dto.ProductsDto

interface ProductApi {

    suspend fun getAllProducts(): List<ProductsDto>
}