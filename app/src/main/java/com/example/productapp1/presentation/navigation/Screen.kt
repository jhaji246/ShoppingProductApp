package com.example.productapp1.presentation.navigation

sealed class Screen(val route: String) {

    object ProductScreen: Screen("product_screen")
}