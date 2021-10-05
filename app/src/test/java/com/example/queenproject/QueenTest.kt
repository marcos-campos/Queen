package com.example.queenproject

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModel
import com.example.queenproject.model.Queen
import com.example.queenproject.model.QueenItem
import com.example.queenproject.repository.RepositoryApi
import com.example.queenproject.ui.main.MainViewModel
import io.mockk.coEvery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)

class QueenTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Test
    fun teste() = runBlocking{

        //Arrange
        val queen = listOf(
            QueenItem(1, "teste", true, "quenn 01", "01", true))

        //Act
        viewModel = MainViewModel(RepositoryApi())

        viewModel.chamarQueenCoroutineOk()

    }
}

class MockRepository(private val result: List<QueenItem>): RepositoryApi(){
    override fun chamarQueenCoroutine(): List<QueenItem> = result
}
