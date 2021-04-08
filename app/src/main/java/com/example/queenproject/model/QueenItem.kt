package com.example.queenproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class QueenItem(

        @SerializedName("id")
    val id: Int?,

        @SerializedName("image_url")
    val imageUrl: String?,

        @SerializedName("missCongeniality")
    val missCongeniality: Boolean?,

        @SerializedName("name")
    val name: String?,

        @SerializedName("quote")
    val quote: String?,

        @SerializedName("winner")
    val winner: Boolean?

) : Serializable