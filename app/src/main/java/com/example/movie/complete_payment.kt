package com.example.movie

import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class complete_payment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_payment)

        val txtAddress = findViewById<TextView>(R.id.txtVenueAddress)
        val btnProceed = findViewById<Button>(R.id.btnProceedToPay)

        // Coordinates provided: 9.9005° N, 78.1202° E
        val lat = 9.9005
        val lon = 78.1202

        try {
            val geocoder = Geocoder(this, Locale.getDefault())
            // Fetching address from lat/long
            val addresses = geocoder.getFromLocation(lat, lon, 1)

            if (addresses != null && addresses.isNotEmpty()) {
                val addressLine = addresses[0].getAddressLine(0)
                txtAddress.text = addressLine
            } else {
                txtAddress.text = "Vetri Cinemas, Villapuram, Madurai"
            }
        } catch (e: Exception) {
            // Fallback text if network/geocoder fails
            txtAddress.text = "Vetri Cinemas, Villapuram, Madurai"
        }

        btnProceed.setOnClickListener {
            // Move to final payment processing screen
            startActivity(Intent(this, payment::class.java))
        }
    }
}