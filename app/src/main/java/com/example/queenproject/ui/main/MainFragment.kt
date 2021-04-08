package com.example.queenproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.queenproject.R
import com.example.queenproject.model.QueenItem
import com.example.queenproject.adapter.AdapterQueen

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    val recycler by lazy { view?.findViewById<RecyclerView>(R.id.recycler_view_queen) }
    private var listQueens = mutableListOf<QueenItem>()

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recycler?.layoutManager = GridLayoutManager(context, 2)

        val adapter = activity?.let { AdapterQueen(listQueens, it) }
        recycler?.adapter = adapter

//        val name = view?.findViewById<TextView>(R.id.message)
//        val imagem = view?.findViewById<ImageView>(R.id.imagem_queen)

        viewModel.chamarQueenCoroutineOk()
        viewModel.queenLiveData.observe(this, Observer {listaQueenOk ->

//            name?.text =listaQueenOk[0].name
//
//            Picasso.with(activity).load(listaQueenOk[0].image_url).into(imagem)

            listQueens.addAll(listaQueenOk)

            adapter?.notifyDataSetChanged()

        })
    }

}