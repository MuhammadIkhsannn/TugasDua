package com.example.logindanregistrasi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val namaList: ArrayList<ItemData>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(ItemData: View) : RecyclerView.ViewHolder(ItemData) {
        val gambar: ImageView = ItemData.findViewById(R.id.imageView2)
        val nama: TextView = ItemData.findViewById(R.id.menu)
        val harga: TextView = ItemData.findViewById(R.id.harga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val ItemData = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        return MyViewHolder(ItemData)
    }

    override fun getItemCount(): Int = namaList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem =namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.harga.text = currentItem.harga
    }
}