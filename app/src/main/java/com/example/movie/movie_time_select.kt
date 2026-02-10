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

        registerForContextMenu(btn)

        btn.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view, Gravity.BOTTOM)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {

                    R.id.menu_payment -> {
                        startActivity(Intent(this, payment::class.java))
                        true
                    }

                    else -> false
                }
            }

            popupMenu.show()
        }
    }

    override fun onCreateContextMenu(
        menu: android.view.ContextMenu,
        v: android.view.View,
        menuInfo: android.view.ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v.id == R.id.button4) {
            menuInflater.inflate(R.menu.context_menu, menu)
        }
    }


    override fun onContextItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menu_proceed_payment -> {
                true
            }

            R.id.menu_view_details -> {
                true
            }

            R.id.menu_change_time -> {
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }



}
