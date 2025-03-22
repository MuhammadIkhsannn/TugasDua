package com.example.logindanregistrasi
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.logindanregistrasi.R

class ImplisitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicite_intent)

        val etText = findViewById<EditText>(R.id.etText)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etLocation = findViewById<EditText>(R.id.etLocation)
        val etWebsite = findViewById<EditText>(R.id.etWebsite)

        val btnShare = findViewById<Button>(R.id.btnShare)
        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnMap = findViewById<Button>(R.id.btnMap)
        val btnWebsite = findViewById<Button>(R.id.btnWebsite)
        val btnCamera = findViewById<Button>(R.id.btnCamera)
        val btnGallery = findViewById<Button>(R.id.btnGallery)
        val btnAlarm = findViewById<Button>(R.id.btnAlarm)

        // Share To
        btnShare.setOnClickListener {
            val text = etText.text.toString()
            if (text.isNotEmpty()) {
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, text)
                }
                startActivity(Intent.createChooser(shareIntent, "Share to"))
            } else {
                Toast.makeText(this, "Input text cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        // Call
        btnCall.setOnClickListener {
            val phone = etPhone.text.toString()
            if (phone.isNotEmpty()) {
                val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                startActivity(callIntent)
            } else {
                Toast.makeText(this, "Phone number cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        // Open Google Map
        btnMap.setOnClickListener {
            val location = etLocation.text.toString()
            if (location.isNotEmpty()) {
                val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$location"))
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            } else {
                Toast.makeText(this, "Location cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        // Open Website
        btnWebsite.setOnClickListener {
            val website = etWebsite.text.toString()
            if (website.isNotEmpty()) {
                var url = website
                if (!website.startsWith("http://") && !website.startsWith("https://")) {
                    url = "http://$website"
                }
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(webIntent)
            } else {
                Toast.makeText(this, "Website URL cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        // Open Camera
        btnCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }

        // Open Gallery
        btnGallery.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivity(galleryIntent)
        }

        // Open Alarm
        btnAlarm.setOnClickListener {
            val alarmIntent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(alarmIntent)
        }
    }
}
