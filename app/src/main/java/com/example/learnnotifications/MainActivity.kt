package com.example.learnnotifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createChannel(
            "notify_channel",
            "Test notify"
        )

        val button = findViewById<Button>(R.id.button)

        val notificationManager = ContextCompat.getSystemService(
            this,
            NotificationManager::class.java
        )

        button.setOnClickListener {
            notificationManager?.sendNotification("Successfull", this)
        }
    }

    private fun createChannel(channelId: String, channelName: String){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            )

            val notificationManager = this.getSystemService(
                NotificationManager::class.java
            )

            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}