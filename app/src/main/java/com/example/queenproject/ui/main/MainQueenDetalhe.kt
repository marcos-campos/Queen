package com.example.queenproject.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.queenproject.R
import com.example.queenproject.model.QueenItem
import com.squareup.picasso.Picasso

class MainQueenDetalhe : AppCompatActivity() {

    val nameQ by lazy { findViewById<TextView>(R.id.detalhe_nome) }
    val descricaoQ by lazy { findViewById<TextView>(R.id.detalhe_descricao) }
    val missQ by lazy { findViewById<TextView>(R.id.detalhe_miss) }
    val winnerQ by lazy { findViewById<TextView>(R.id.detalhe_winner) }
    val imagemQ by lazy { findViewById<ImageView>(R.id.detalhe_imagem) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhe_queen)

        val informacoes = intent.extras

        if (informacoes != null) {

            val queen = informacoes.getSerializable("QUEEN") as QueenItem

            nameQ.text = queen.name
            Picasso.with(this).load(queen.imageUrl).into(imagemQ)
            descricaoQ.text = queen.quote
            missQ.text = queen.missCongeniality.toString()
            winnerQ.text = queen.winner.toString()

//            descricaoQ.text = informacoes.getString("DESCRICAO")
//            missQ.text = informacoes.getBoolean("MISS").toString()
//            winnerQ.text = informacoes.getBoolean("WINNER").toString()
//            val imagemOk = informacoes.getString("IMAGEM")
//            Picasso.with(this).load(imagemOk).into(imagemQ)

        }



    }

}

