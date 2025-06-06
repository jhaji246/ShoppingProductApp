package com.example.productapp1.domain.repository

import com.example.productapp1.core.common.Resource
import com.example.productapp1.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getAllProducts(): Flow<Resource<List<Product>>>
}