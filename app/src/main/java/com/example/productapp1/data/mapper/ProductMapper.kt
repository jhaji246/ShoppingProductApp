package com.example.productapp1.data.mapper

import com.example.productapp1.data.dto.ProductsDto
import com.example.productapp1.domain.model.Product

fun ProductsDto.toDomainProduct(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        image = image
    )
}