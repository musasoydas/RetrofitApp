package com.example.besinapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.besinapp.model.Besin

class BesinDetayiViewModel : ViewModel() {

    var besinLiveData= MutableLiveData<Besin>()

    fun roomVerisiniAl(){
        val muz=Besin("muz","100", "50","150","1","www.test.com")
        besinLiveData.value=muz

    }

}