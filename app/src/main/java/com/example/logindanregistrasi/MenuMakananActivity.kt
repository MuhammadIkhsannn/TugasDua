package com.example.logindanregistrasi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuMakananActivity : AppCompatActivity() {
    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var menuAdapter: MyAdapter
    private lateinit var listMenu : ArrayList<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_makanan)

        menuRecyclerView = findViewById(R.id.menuRecyclerView)
        listMenu = ArrayList()

        listMenu.add(ItemData(R.drawable.nasigoreng, "Nasi Goreng", "20.000"))
        listMenu.add(ItemData(R.drawable.nasikuning, "Nasi Kuning", "15.000"))
        listMenu.add(ItemData(R.drawable.sotoayam, "Soto Ayam", "30.000"))
        listMenu.add(ItemData(R.drawable.mieayam, "Mie Ayam", "25.000"))
        listMenu.add(ItemData(R.drawable.ayambakar, "Ayam Bakar", "25.000"))
        listMenu.add(ItemData(R.drawable.ayamgeprek, "Ayam Geprek", "20.000"))
        listMenu.add(ItemData(R.drawable.bakso, "Bakso", "20.000"))
        listMenu.add(ItemData(R.drawable.cotomakassar, "Coto Makassar", "40.000"))
        listMenu.add(ItemData(R.drawable.ikanbakar, "Ikan Bakar", "80.000"))
        listMenu.add(ItemData(R.drawable.nasipadang, "Nasi Padang", "35.000"))

        menuRecyclerView.layoutManager = GridLayoutManager(this, 2)
        menuRecyclerView.setHasFixedSize(true)
        menuAdapter = MyAdapter(listMenu)
        menuRecyclerView.adapter = menuAdapter
    }

}