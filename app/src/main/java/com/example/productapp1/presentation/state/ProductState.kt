package com.example.productapp1.presentation.state

import com.example.productapp1.domain.model.Product

data class ProductState(
    val products: List<Product> ? = emptyList(),
    val errorMsg: String ? = "",
    val isLoading: Boolean = false
)
