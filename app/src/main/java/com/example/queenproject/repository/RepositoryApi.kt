package com.example.queenproject.repository

import com.example.queenproject.model.QueenItem
import com.example.queenproject.network.EndPoints
import com.example.queenproject.network.RetrofitInit

open class RepositoryApi {

    private var url = "http://www.nokeynoshade.party/api/queens/"

    private var service = EndPoints::class

    val conectionService = RetrofitInit(url).create(service)

    open fun chamarQueenCoroutine(): List<QueenItem> = conectionService.chamarQueen()

}