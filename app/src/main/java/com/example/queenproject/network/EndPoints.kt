package com.example.queenproject.network

import com.example.queenproject.model.QueenItem
import retrofit2.http.GET

interface EndPoints {

    @GET("all")
    open fun chamarQueen() : List<QueenItem>

}