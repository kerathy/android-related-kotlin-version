package com.example.geofenceintentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingEvent

class GeofenceIntentService : IntentService("GeofenceIntentService") {

    val TAG = "GeofenceIntentService"

    override fun onHandleIntent(p0: Intent?) {
        val geofenceIntent = GeofencingEvent.fromIntent(p0)
        Log.i(TAG, "onHandleIntent")
        if (geofenceIntent.hasError()) {
            val errorMessage = geofenceIntent.errorCode
            Log.i(TAG, errorMessage.toString())
            return
        }

        val geofenceTransition = geofenceIntent.geofenceTransition
        var type = ""

        when(geofenceTransition){
            Geofence.GEOFENCE_TRANSITION_EXIT -> type = "EXIT"
            Geofence.GEOFENCE_TRANSITION_ENTER -> type = "ENTER"
            Geofence.GEOFENCE_TRANSITION_DWELL -> type = "DWELL"
            else -> type = "Nothing"
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(Intent("transition_broadcast").putExtra("action", type))
    }
}