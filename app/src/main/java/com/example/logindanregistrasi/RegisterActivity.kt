package com.example.logindanregistrasi

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.logindanregistrasi.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonregister.setOnClickListener {
            val username :String = binding.textInputUsername.text.toString().trim()
            val password : String = binding.textInputPassword.text.toString().trim()
            val rePassword :String = binding.textInputRePassword.text.toString().trim()

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

            if (password != rePassword){
                binding.textInputRePassword.error= "password must be match"
                binding.textInputRePassword.requestFocus()
                return@setOnClickListener
            }
            registerUser(username, password)
        }
        binding.textloginsekarang.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser(username:String, password:String){
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
