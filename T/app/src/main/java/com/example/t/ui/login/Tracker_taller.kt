package com.example.t.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.t.R

class Tracker_taller : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val folio:String = intent.getStringExtra("folio")
        setContentView(R.layout.activity_tracker_taller)
    }
}