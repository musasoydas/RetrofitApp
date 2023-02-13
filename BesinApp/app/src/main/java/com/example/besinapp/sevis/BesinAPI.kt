package com.example.besinapp.sevis

import com.example.besinapp.model.Besin
import io.reactivex.Single
import retrofit2.http.GET

interface BesinAPI {

        //https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
        //Base url ana url

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesin(): Single<List<Besin>>
}