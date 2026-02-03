package com.example.movie
import android.content.Intent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class movie_time_select : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_time_select)

        val btn = findViewById<Button>(R.id.button4)
        btn.setOnClickListener {
            val intent = Intent(this, payment::class.java)
            startActivity(intent)
        }
    }
}