package com.example.productapp1.presentation.viewmodel

import com.example.productapp1.core.common.Resource
import com.example.productapp1.domain.model.Product
import com.example.productapp1.domain.usecase.ProductUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class ProductViewModelTest {

    private lateinit var viewModel: ProductViewModel
    private lateinit var useCase: ProductUseCase

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        useCase = mockk()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should return loading and then success`() = runTest {
        val mockProducts = listOf(
            Product(
                id = 1,
                title = "Camera",
                description = "Awesome Camera",
                image = "https://products.camera"
            )
        )
        coEvery { useCase() } returns flow {
            emit(Resource.Loading())
            emit(Resource.Success(mockProducts))
        }

        viewModel = ProductViewModel(useCase)
        advanceUntilIdle()
        val state = viewModel.productState.value

        assertFalse(state.isLoading)
        assertEquals(mockProducts, state.products)
    }

    @Test
    fun `should return loading and then error`() = runTest {

        val errorMsgs = "SomeThing went wrong"
        coEvery { useCase() } returns flow {
            emit(Resource.Loading())
            emit(Resource.Error(errorMsgs))
        }

        val viewModel = ProductViewModel(useCase)

        advanceUntilIdle()

        val state = viewModel.productState.value

        assertFalse(state.isLoading)
        assertEquals(errorMsgs, state.errorMsg)
    }
}