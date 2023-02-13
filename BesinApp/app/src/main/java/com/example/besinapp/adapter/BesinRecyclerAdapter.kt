package com.example.besinapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.besinapp.R
import com.example.besinapp.model.Besin
import com.example.besinapp.util.creatPlaceHolder
import com.example.besinapp.util.gorselIndir
import com.example.besinapp.view.BesinListesiDirections
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.besin_recycler_row.view.*
import kotlinx.android.synthetic.main.fragment_besin_detayi.view.*


class BesinRecyclerAdapter(val besinList: ArrayList<Besin>) :RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {
    class BesinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        var inflater=LayoutInflater.from(parent.context).inflate(R.layout.besin_recycler_row,parent,false)
        return BesinViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.itemView.recycler_view_besinIsmi.text = besinList.get(position).besinIsmi
        holder.itemView.recycler_view_besinKalorisi.text = besinList.get(position).besinkalori

        holder.itemView.setOnClickListener {
            val action=BesinListesiDirections.actionBesinListesiToBesinDetayi(0)
            Navigation.findNavController(it).navigate(action)
        }
        //picasso ile yapılışı bu şekilde
        //Picasso.get().load(besinList[position].besingorsel).into(holder.itemView.recycler_view_besinResmi)

        //glide öğrenmek için yaptım
        holder.itemView.imageView.gorselIndir(besinList.get(position).besingorsel, creatPlaceHolder(holder.itemView.context))


    }

    override fun getItemCount(): Int {
        return besinList.size
    }

    fun besinListesiniGuncelle(yeniBesinListesi:List<Besin>)
    {
        besinList.clear()
        besinList.addAll(yeniBesinListesi)
        notifyDataSetChanged()
    }
}