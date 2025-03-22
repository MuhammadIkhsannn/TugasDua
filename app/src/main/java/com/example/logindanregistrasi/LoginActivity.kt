package com.example.logindanregistrasi

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.logindanregistrasi.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()


        // Login button click listener
        binding.buttonlogin.setOnClickListener {
            val username :String = binding.textInputUsername.text.toString().trim()
            val password : String = binding.textInputPassword.text.toString().trim()

            if (username.isEmpty()){
                binding.textInputUsername.error= "Input Username"
                binding.textInputUsername.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
                binding.textInputUsername.error= "Invalid Username"
                binding.textInputUsername.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6){
                binding.textInputPassword.error= "password must be more than 6 characters"
                binding.textInputPassword.requestFocus()
                return@setOnClickListener
            }

            loginUser(username, password)
        }

        // Create Account text click listener
        binding.textBuatAkun.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Forgot Password text click listener
        binding.textLupaPassword.setOnClickListener {
            val intent = Intent(this, LupaPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(username:String, password:String){
        firebaseAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener {
            if (it.isSuccessful) {
                Intent(this, MenuMakananActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser !=null) {
            Intent(this, MenuMakananActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}
