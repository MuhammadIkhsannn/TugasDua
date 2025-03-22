package com.example.logindanregistrasi

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

                val ItemData= intent.getParcelableExtra<ItemData>("ItemData")
                val image: ImageView = findViewById(R.id.detailImage)
                val title: TextView = findViewById(R.id.detailmenu)
                val Desc: TextView = findViewById(R.id.detailDesc)

                    ItemData?.let {
                        image.setImageResource(it.gambar)
                        title.text = it.menu
                        Desc.text = it.desc
                    }
                }
            }