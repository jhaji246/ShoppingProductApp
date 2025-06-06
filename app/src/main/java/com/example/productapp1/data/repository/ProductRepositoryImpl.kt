package com.example.productapp1.data.repository

import com.example.productapp1.core.common.Resource
import com.example.productapp1.data.api.ProductApi
import com.example.productapp1.data.mapper.toDomainProduct
import com.example.productapp1.domain.model.Product
import com.example.productapp1.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val productApi: ProductApi) :
    ProductRepository {

    override fun getAllProducts(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        val result = productApi.getAllProducts().map { it.toDomainProduct() }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }
}