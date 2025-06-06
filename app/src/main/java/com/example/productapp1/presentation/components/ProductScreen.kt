package com.example.productapp1.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.productapp1.presentation.state.ProductState

@Composable
fun ProductScreen(modifier: Modifier, productState: ProductState) {

    if (productState.isLoading) {
        Box(modifier = modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
        }
    }

    if (productState.errorMsg.isNullOrEmpty()) {
        Box(modifier = modifier.fillMaxSize()) {
            Text(text = productState.errorMsg.toString(), modifier.align(Alignment.Center))
        }
    }

    if (productState.products?.isNotEmpty()!!) {
        LazyColumn {
            items(productState.products) {
                ProductItem(modifier = modifier, product = it)
            }
        }
    }
}