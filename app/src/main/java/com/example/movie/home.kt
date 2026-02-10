package com.example.movie
import android.widget.LinearLayout // Added this
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent // Added this
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar


class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val btn = findViewById<Button>(R.id.loginButton)

        val movie = findViewById<LinearLayout>(R.id.movie1)
        movie.setOnClickListener {
            val intent = Intent(this, movie_time_select::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menu_profile -> {
                true
            }

            R.id.menu_settings -> {
                true
            }

            R.id.menu_help -> {
                true
            }

            R.id.menu_logout -> {
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}