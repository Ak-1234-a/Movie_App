package com.example.movie

import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import java.util.Locale

class complete_payment : AppCompatActivity() {

    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Initialize OSMDroid Configuration
        // This must be done BEFORE setContentView
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        setContentView(R.layout.activity_complete_payment)

        val txtAddress = findViewById<TextView>(R.id.txtVenueAddress)
        val btnProceed = findViewById<Button>(R.id.btnProceedToPay)
        map = findViewById<MapView>(R.id.mapView)

        // Coordinates for Vetri Cinemas, Madurai
        val lat = 9.9005
        val lon = 78.1202
        val moviePoint = GeoPoint(lat, lon)

        // 2. Configure the Map View
        map.setMultiTouchControls(true)
        val mapController = map.controller
        mapController.setZoom(17.0)
        mapController.setCenter(moviePoint)

        // 3. Add a Marker to the Map
        val marker = Marker(map)
        marker.position = moviePoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.title = "Vetri Cinemas"
        marker.snippet = "Villapuram, Madurai"
        map.overlays.add(marker)

        // 4. Geocoder for Address Text
        try {
            val geocoder = Geocoder(this, Locale.getDefault())
            val addresses = geocoder.getFromLocation(lat, lon, 1)

            if (addresses != null && addresses.isNotEmpty()) {
                val addressLine = addresses[0].getAddressLine(0)
                txtAddress.text = addressLine
            } else {
                txtAddress.text = "Vetri Cinemas, Villapuram, Madurai"
            }
        } catch (e: Exception) {
            txtAddress.text = "Vetri Cinemas, Villapuram, Madurai"
        }

        // 5. Button Logic
        btnProceed.setOnClickListener {
            startActivity(Intent(this, payment::class.java))
        }
    }

    // 6. Manage Map Lifecycle
    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}