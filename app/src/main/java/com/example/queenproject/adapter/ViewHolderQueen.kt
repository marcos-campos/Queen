package com.example.queenproject.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.queenproject.R

class ViewHolderQueen (view: View): RecyclerView.ViewHolder(view) {

    val nomeQuenn by lazy { view.findViewById<TextView>(R.id.nome_queen)}
    val imagemQuenn by lazy { view.findViewById<ImageView>(R.id.image_card_view)}

}