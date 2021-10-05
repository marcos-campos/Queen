package com.example.queenproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.queenproject.R
import com.example.queenproject.model.QueenItem
import com.example.queenproject.adapter.AdapterQueen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    /** declarando as variaveis */

    val recycler by lazy { view?.findViewById<RecyclerView>(R.id.recycler_view_queen) }
    private var listQueens = mutableListOf<QueenItem>()
    private val viewModel: MainViewModel by viewModel()
    lateinit var progressBar : ProgressBar

    /** ON CREATE */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progressBar = view?.findViewById<ProgressBar>(R.id.progress_bar)!!

        recycler?.layoutManager = GridLayoutManager(context, 2)

        val adapter = activity?.let { AdapterQueen(listQueens, it) }
        recycler?.adapter = adapter

        /** ViewModel chamar os personagens Queen*/

        viewModel.chamarQueenCoroutineOk()
        viewModel.queenLiveData.observe(viewLifecycleOwner, Observer {listaQueenOk ->

            listQueens.addAll(listaQueenOk)
            adapter?.notifyDataSetChanged()

        })

        /** ViewModel do loading*/

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it) {
                progressBar.visibility = VISIBLE
            } else {
                progressBar.visibility = GONE
            }
        })

        /** ViewModel dos erros*/

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

}