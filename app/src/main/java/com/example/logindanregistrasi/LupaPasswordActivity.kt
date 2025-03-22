package com.example.logindanregistrasi

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.logindanregistrasi.databinding.ActivityLupaPasswordBinding

class LupaPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLupaPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLupaPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonReset.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            if (isValidEmail(email)) {
                Toast.makeText(this, "Link reset dikirim ke $email", Toast.LENGTH_SHORT).show()
                // Optionally, navigate back to Login
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out) // Transisi animasi
                finish()
            } else {
                binding.editTextEmail.error = "Format email tidak valid"
            }
        }

        binding.textBackToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
