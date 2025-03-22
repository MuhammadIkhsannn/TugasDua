package com.example.logindanregistrasi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ImpliciteIntentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicite_intent);

        EditText etText = findViewById(R.id.etText);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etLocation = findViewById(R.id.etLocation);
        EditText etWebsite = findViewById(R.id.etWebsite);

        Button btnShare = findViewById(R.id.btnShare);
        Button btnCall = findViewById(R.id.btnCall);
        Button btnMap = findViewById(R.id.btnMap);
        Button btnWebsite = findViewById(R.id.btnWebsite);
        Button btnCamera = findViewById(R.id.btnCamera);
        Button btnGallery = findViewById(R.id.btnGallery);
        Button btnAlarm = findViewById(R.id.btnAlarm);

        // Share To
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etText.getText().toString();
                if (!text.isEmpty()) {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(shareIntent, "Share to"));
                } else {
                    Toast.makeText(ImpliciteIntentActivity.this, "Input text cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Call
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etPhone.getText().toString();
                if (!phone.isEmpty()) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                    startActivity(callIntent);
                } else {
                    Toast.makeText(ImpliciteIntentActivity.this, "Phone number cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Open Google Map
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = etLocation.getText().toString();
                if (!location.isEmpty()) {
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(ImpliciteIntentActivity.this, "Location cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Open Website
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String website = etWebsite.getText().toString();
                if (!website.isEmpty()) {
                    if (!website.startsWith("http://") && !website.startsWith("https://")) {
                        website = "http://" + website;
                    }
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                    startActivity(webIntent);
                } else {
                    Toast.makeText(ImpliciteIntentActivity.this, "Website URL cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Open Camera
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
            }
        });

        // Open Gallery
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(galleryIntent);
            }
        });

        // Open Alarm
        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alarmIntent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                startActivity(alarmIntent);
            }
        });
    }
}