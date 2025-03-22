package com.example.logindanregistrasi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.logindanregistrasi.R

class Activity_About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Mendapatkan referensi ke elemen-elemen di layout
        val tvAboutTitle = findViewById<TextView>(R.id.tvAboutTitle)
        val tvAboutDescription = findViewById<TextView>(R.id.tvAboutDescription)
    }
}
