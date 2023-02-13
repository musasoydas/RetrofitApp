package com.example.besinapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.besinapp.R
import com.example.besinapp.viewmodel.BesinDetayiViewModel
import kotlinx.android.synthetic.main.besin_recycler_row.*
import kotlinx.android.synthetic.main.fragment_besin_detayi.*

class BesinDetayi : Fragment() {
    private lateinit var viewModel: BesinDetayiViewModel
    var besinId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detayi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(BesinDetayiViewModel::class.java)
        viewModel.roomVerisiniAl()
        arguments?.let {
            besinId=BesinDetayiArgs.fromBundle(it).besinId
        }
        observeLiveData()
    }
    fun observeLiveData(){
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer { besin ->
            besin?.let {
                besinIsmi.text=it.besinIsmi
                besinKalori.text=it.besinkalori
                besinKarbonhidrat.text=it.besinkarbonhidrat
                besinProtein.text=it.besinprotein
                besinYag.text=it.besinyag

            }

        })
    }


}