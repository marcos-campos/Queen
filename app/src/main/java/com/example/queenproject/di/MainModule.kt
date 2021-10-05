package com.example.queenproject.di

import com.example.queenproject.repository.RepositoryApi
import com.example.queenproject.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    factory {
        RepositoryApi()
    }

    viewModel {
        MainViewModel(
            repository = get()
        )
    }
}