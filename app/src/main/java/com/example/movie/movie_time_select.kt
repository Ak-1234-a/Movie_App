package com.example.movie

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.movie.R
import com.example.movie.payment

class movie_time_select : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_time_select)

        val btn = findViewById<Button>(R.id.button4)

        btn.setOnClickListener { view ->

            val popupMenu = PopupMenu(this, view, Gravity.BOTTOM)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_payment -> {
                        startActivity(Intent(this, payment::class.java))
                        true
                    }

                    R.id.menu_other -> {
                        true
                    }

                    else -> false
                }
            }

            popupMenu.show()
        }
    }
}
