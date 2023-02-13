package com.example.besinapp.sevis

import com.example.besinapp.model.Besin
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BesinAPIServis {
    //https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
    //Base url ana url
    private var BASE_URL = "https://raw.githubusercontent.com/"
    private var api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(BesinAPI::class.java)

    fun getData(): Single<List<Besin>> {
        return api.getBesin()
    }
}