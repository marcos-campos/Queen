package com.example.queenproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.queenproject.model.QueenItem
import com.example.queenproject.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.UnknownHostException

class MainViewModel(private val repository: RepositoryApi) : ViewModel() {

    val queenLiveData = MutableLiveData<List<QueenItem>>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun chamarQueenCoroutineOk() {
        CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)

            try {
            repository.chamarQueenCoroutine().let {
                queenLiveData.postValue(it)
                loading.postValue(false) }
        }
            catch (error: Throwable) {
                loading.postValue(false)
                enviarErro(error)
            }
        }
    }

    private fun enviarErro(error: Throwable) {
        when(error){
            is HttpException -> errorMessage.postValue("erro de conexão código ${error.code()}")
            is UnknownHostException -> errorMessage.postValue("verifique sua conexão")
        }
    }
}