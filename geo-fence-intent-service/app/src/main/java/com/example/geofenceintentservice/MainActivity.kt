package com.example.geofenceintentservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {

    lateinit var myBroadCastReceiver: MyBroadCastReceiver
    lateinit var button: Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)

        button.setOnClickListener(View.OnClickListener {
            val intentService : Intent = Intent(this, GeofenceIntentService::class.java)
            startService(intentService)
        })
    }

    private fun setReceiver() {
        myBroadCastReceiver = MyBroadCastReceiver()
        val intentFilter = IntentFilter("transition_broadcast")
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadCastReceiver, intentFilter)
    }

    override fun onStart() {
        setReceiver()
        super.onStart()
    }

    override fun onStop() {
        unregisterReceiver(myBroadCastReceiver)
        super.onStop()
    }

    inner class MyBroadCastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            val message = intent.getStringExtra("action")
            textView.setText("geofenceintentservice type: $message")
        }
    }
}