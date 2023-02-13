package com.example.besinapp.model

import com.google.gson.annotations.SerializedName

data class Besin(
    @SerializedName("isim")
    var besinIsmi: String?,
    @SerializedName("kalori")
    var besinkalori: String?,
    @SerializedName("karbonhidrat")
    var besinkarbonhidrat: String?,
    @SerializedName("protein")
    var besinprotein: String?,
    @SerializedName("yag")
    var besinyag: String?,
    @SerializedName("gorsel")
    var besingorsel: String?
) {
}