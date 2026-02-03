package com.example.movie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btn = findViewById<Button>(R.id.loginButton)

        btn.setOnClickListener {

            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
    } // This closes onCreate
} // This closes the MainActivity class