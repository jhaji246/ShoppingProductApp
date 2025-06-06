package com.example.productapp1.domain.usecase

import com.example.productapp1.domain.repository.ProductRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val repository: ProductRepository){

    operator fun invoke() = repository.getAllProducts()
}