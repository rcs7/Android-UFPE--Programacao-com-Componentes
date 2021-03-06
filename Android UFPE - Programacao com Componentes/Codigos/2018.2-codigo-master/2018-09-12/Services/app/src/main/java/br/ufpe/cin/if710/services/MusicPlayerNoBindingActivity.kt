package br.ufpe.cin.if710.services

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_music_player_no_binding.*

class MusicPlayerNoBindingActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player_no_binding)

        val serviceIntent = Intent(this, MusicPlayerNoBindingService::class.java)

        btn_StartService.setOnClickListener { startService(serviceIntent) }

        btn_StopService.setOnClickListener { stopService(serviceIntent) }
    }
}
