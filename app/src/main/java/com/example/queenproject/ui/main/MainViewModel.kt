package com.example.queenproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.queenproject.model.QueenItem
import com.example.queenproject.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val queenLiveData = MutableLiveData<List<QueenItem>>()
    val repository = RepositoryApi()

    fun chamarQueenCoroutineOk() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.chamarQueenCoroutine().let {
                queenLiveData.postValue(it)
            }
        }
    }


}