package com.example.logindanregistrasi

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//   membuat View holder / meng-Extend RecyclerView.adapter
class MyAdapter(private val namaList: ArrayList<ItemData>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(ItemData: View) : RecyclerView.ViewHolder(ItemData) {
        val gambar: ImageView = ItemData.findViewById(R.id.imageView2)
        val nama: TextView = ItemData.findViewById(R.id.menu)
        val harga: TextView = ItemData.findViewById(R.id.desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val ItemData = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        return MyViewHolder(ItemData)
    }

    override fun getItemCount(): Int = namaList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val context = holder.itemView.context
        val currentItem =namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.menu
        holder.harga.text = currentItem.desc

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("ItemData", currentItem)
            context.startActivity(intent)
        }
    }
}