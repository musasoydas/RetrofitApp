package com.example.besinapp.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.besinapp.R

fun ImageView.gorselIndir(url:String? ,placeholders: CircularProgressDrawable){
    val options=RequestOptions().placeholder(placeholders).error(R.mipmap.ic_launcher_round)
    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)
}
fun creatPlaceHolder(context: Context): CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth=8f
        centerRadius=40f
        start()
    }

}