package com.example.logindanregistrasi

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.logindanregistrasi.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonregister.setOnClickListener {
            val username = binding.textInputUsername.editText?.text.toString()
            val password = binding.textInputPassword.editText?.text.toString()
            val rePassword = binding.textInputRePassword.editText?.text.toString()

            if (username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else if (password != rePassword) {
                Toast.makeText(this, "Password dan Re-Password tidak sama!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Anda dapat menggunakan username ini untuk login nanti", Toast.LENGTH_LONG).show()
            }
        }
        binding.textloginsekarang.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
