package com.example.besinapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.besinapp.model.Besin
import com.example.besinapp.sevis.BesinAPIServis
import com.example.besinapp.view.BesinListesi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class BesinListesiViewModel :ViewModel(){
    val besinler=MutableLiveData<List<Besin>>()
    val besinHataMesaji=MutableLiveData<Boolean>()
    val besinYukleniyor=MutableLiveData<Boolean>()

    private var besinApiServis = BesinAPIServis()
    private var disposable =CompositeDisposable()

    fun refreshData(){
    verileriInternettenAl()
    }
    fun verileriInternettenAl()
    {
        besinYukleniyor.value=true
        disposable.add(
            besinApiServis.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Besin>>(){
                    override fun onSuccess(t: List<Besin>) {
                       //Başarılı olursak ne yapacağız
                        besinler.value=t
                        besinHataMesaji.value=false
                        besinYukleniyor.value=false
                    }

                    override fun onError(e: Throwable) {
                        //hata alırsak ne olacak
                        besinHataMesaji.value=true
                        besinYukleniyor.value=false
                        e.printStackTrace()
                    }

                })
        )
    }
}