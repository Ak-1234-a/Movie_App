package com.example.movie

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class payment : AppCompatActivity() {
    private val CHANNEL_ID = "movie_booking_channel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val progressBar = findViewById<ProgressBar>(R.id.paymentProgress)
        val successText = findViewById<TextView>(R.id.successText)

        createNotificationChannel()

        // Check for Android 13+ permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 101)
        }

        // Processing delay
        Handler(Looper.getMainLooper()).postDelayed({
            progressBar.visibility = View.GONE
            successText.visibility = View.VISIBLE

            sendNotification()
        }, 3000)
    }

    private fun sendNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.logo) // Using your logo.png here
            .setContentTitle("Booking Confirmed!")
            .setContentText("Your payment was successful. Enjoy the movie!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setAutoCancel(true)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, builder.build())
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Booking Status",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Confirmations for movie bookings"
            }
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}