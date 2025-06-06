package com.example.productapp1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp1.core.common.Resource
import com.example.productapp1.domain.usecase.ProductUseCase
import com.example.productapp1.presentation.state.ProductState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val useCase: ProductUseCase) : ViewModel() {

    private val _productState = MutableStateFlow(ProductState())
    val productState: StateFlow<ProductState>
        get() = _productState

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        useCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _productState.value = ProductState().copy(isLoading = true)
                }

                is Resource.Error -> {
                    _productState.value = ProductState().copy(errorMsg = it.msg.toString())
                }

                is Resource.Success -> {
                    _productState.value = ProductState().copy(products = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}