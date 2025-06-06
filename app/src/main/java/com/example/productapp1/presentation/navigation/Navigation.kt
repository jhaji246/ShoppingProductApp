package com.example.productapp1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.*
import com.example.productapp1.presentation.components.ProductScreen
import com.example.productapp1.presentation.viewmodel.ProductViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ProductScreen.route) {
        composable(Screen.ProductScreen.route) {
            val productViewModel = hiltViewModel<ProductViewModel>()
            val productState = productViewModel.productState.collectAsStateWithLifecycle().value
            ProductScreen(modifier = Modifier, productState = productState)
        }
    }
}