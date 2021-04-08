package com.example.queenproject.repository

import com.example.queenproject.model.QueenItem
import com.example.queenproject.network.EndPoints
import com.example.queenproject.network.RetrofitInit

class RepositoryApi {

    private var url = "http://www.nokeynoshade.party/api/queens/"

    private var service = EndPoints::class

    private val conectionService = RetrofitInit(url).create(service)

    suspend fun chamarQueenCoroutine(): List<QueenItem> = conectionService.chamarQueen()

}