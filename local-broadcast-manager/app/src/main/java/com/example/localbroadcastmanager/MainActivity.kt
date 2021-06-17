package com.example.localbroadcastmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var myBroadcastReceiver: MyBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilter = IntentFilter()
        myBroadcastReceiver = MyBroadcastReceiver()

        intentFilter.addAction("YOUR_ACTION")
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcastReceiver, intentFilter)

        button.setOnClickListener{
            val intent = Intent(this, BroadCast::class.java)
            startActivity(intent)
        }
    }

    inner class MyBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent){
            when (intent.action) {
                "YOUR_ACTION" -> {
                    val data = intent.getStringExtra("DATA")
                    textView2.text = data
                    if (data != null) {
                        Log.d("Your Received data : ", data)
                    }
                }
                else -> Toast.makeText(context, "Action Not Found", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcastReceiver)
    }
}