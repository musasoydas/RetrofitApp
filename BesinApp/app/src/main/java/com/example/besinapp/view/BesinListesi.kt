package com.example.besinapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.besinapp.R
import com.example.besinapp.adapter.BesinRecyclerAdapter
import com.example.besinapp.viewmodel.BesinListesiViewModel
import kotlinx.android.synthetic.main.besin_recycler_row.*
import kotlinx.android.synthetic.main.fragment_besin_listesi.*
import kotlinx.android.synthetic.main.fragment_besin_listesi.view.*


class BesinListesi : Fragment() {
    private lateinit var viewModel: BesinListesiViewModel
    private var recyclerBesinAdapter= BesinRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_listesi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProviders.of(this).get(BesinListesiViewModel::class.java)
        viewModel.refreshData()

        besinListesirecyclerView.layoutManager=LinearLayoutManager(context)
        besinListesirecyclerView.adapter=recyclerBesinAdapter
        swipeRefreshLayout.setOnRefreshListener {
            besinHataMesaji.visibility=View.VISIBLE
            besinYukleniyor.visibility=View.GONE
            besinListesirecyclerView.visibility=View.GONE
            swipeRefreshLayout.isRefreshing=false

            viewModel.refreshData()
        }
        observeLiveData()
    }
    fun observeLiveData(){
        viewModel.besinler.observe(viewLifecycleOwner, Observer {besinler ->
            besinler?.let {
                besinListesirecyclerView.visibility=View.VISIBLE
                 recyclerBesinAdapter.besinListesiniGuncelle(besinler)
            }

        })
        viewModel.besinYukleniyor.observe(viewLifecycleOwner, Observer {yukleniyor ->
            yukleniyor?.let {
                 if(it==true)
                 {
                     besinListesirecyclerView.visibility=View.GONE
                     besinHataMesaji.visibility=View.GONE
                     besinYukleniyor.visibility=View.VISIBLE
                 }
                else{
                    besinYukleniyor.visibility=View.GONE
                 }
            }
        })
        viewModel.besinHataMesaji.observe(viewLifecycleOwner, Observer {hata ->
        hata?.let {
            if(it==true)
            {
                besinListesirecyclerView.visibility=View.GONE
                besinHataMesaji.visibility=View.VISIBLE
            }
            else{
                besinHataMesaji.visibility=View.GONE
            }
        }

        })
    }


}