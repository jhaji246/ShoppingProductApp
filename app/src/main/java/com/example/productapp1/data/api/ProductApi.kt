package com.example.productapp1.data.api

import com.example.productapp1.data.dto.ProductsDto
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getAllProducts(): List<ProductsDto>
}