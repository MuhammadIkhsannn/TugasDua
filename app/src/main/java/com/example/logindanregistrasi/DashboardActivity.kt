package com.example.logindanregistrasi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.logindanregistrasi.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonLogout.setOnClickListener {
            finish()
        }

    }
}