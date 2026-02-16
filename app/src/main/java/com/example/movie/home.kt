package com.example.movie

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Setup Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Movie"

        findViewById<LinearLayout>(R.id.movie1).setOnClickListener {
            startActivity(Intent(this, movie_time_select::class.java))
        }

        // Back press confirmation
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AlertDialog.Builder(this@home)
                    .setTitle("Exit")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes") { _, _ -> finishAffinity() }
                    .setNegativeButton("No", null)
                    .show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_profile -> {
                return true
            }

            R.id.menu_settings -> {
                return true
            }

            R.id.menu_help -> {
                return true
            }

            R.id.menu_logout -> {
                finishAffinity()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
