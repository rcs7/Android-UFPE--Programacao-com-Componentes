package br.ufpe.cin.if710.systemservices.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

import java.text.DateFormat
import java.util.Date

class AlarmLogReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("IF710", "Alarme registrado em:" + DateFormat.getDateTimeInstance().format(Date()))
    }
}
