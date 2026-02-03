package com.example.movie
import android.widget.LinearLayout // Added this
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent // Added this

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val movie = findViewById<LinearLayout>(R.id.movie1)
        movie.setOnClickListener {
            val intent = Intent(this, movie_time_select::class.java)
            startActivity(intent)
        }
    }
}