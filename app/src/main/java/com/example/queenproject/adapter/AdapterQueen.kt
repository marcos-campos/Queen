package com.example.queenproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.queenproject.R
import com.example.queenproject.model.QueenItem
import com.example.queenproject.ui.main.MainQueenDetalhe
import com.squareup.picasso.Picasso

class AdapterQueen(
        private val listaDeQueens: MutableList<QueenItem>,
        private val context: Context
) : RecyclerView.Adapter<ViewHolderQueen>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderQueen {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_queen, parent, false)
        return ViewHolderQueen(view)
    }

    override fun getItemCount(): Int = listaDeQueens.size


    override fun onBindViewHolder(holder: ViewHolderQueen, position: Int) {
        val nameOfQueen = holder.nomeQuenn
        nameOfQueen.text = listaDeQueens[position].name

        val imgOfQueen = listaDeQueens.elementAt(position)
        Picasso.with(context).load(imgOfQueen.imageUrl).into(holder.imagemQuenn)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, MainQueenDetalhe::class.java)

            intent.putExtra("QUEEN", listaDeQueens[position])

//            intent.putExtra("DESCRICAO", listaDeQueens[position].quote)
//            intent.putExtra("WINNER", listaDeQueens[position].winner)
//            intent.putExtra("MISS", listaDeQueens[position].missCongeniality)
//            intent.putExtra("NOME", listaDeQueens[position].name)
//            intent.putExtra("IMAGEM", listaDeQueens[position].imageUrl)

            it.context.startActivity(intent)


        }
    }
}
