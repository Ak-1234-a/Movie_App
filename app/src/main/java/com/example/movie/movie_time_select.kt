package com.example.movie

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity

class movie_time_select : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_time_select)

        val btn = findViewById<Button>(R.id.button4)
        btn.setOnClickListener { view ->
            val popup = PopupMenu(this, view, Gravity.BOTTOM)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                if (item.itemId == R.id.menu_payment) {
                    startActivity(Intent(this, complete_payment::class.java))
                }
                true
            }
            popup.show()
        }
    }
}