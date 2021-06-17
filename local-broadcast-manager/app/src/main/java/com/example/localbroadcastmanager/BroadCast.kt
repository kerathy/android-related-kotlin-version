package com.example.localbroadcastmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class BroadCast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_cast)

        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener{
            val intent = Intent("YOUR_ACTION")
                .putExtra("DATA", "MindOrks")
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }
    }
}