package com.example.t.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.t.R
import kotlinx.android.synthetic.main.activity_tracker_taller.*

class Tracker_tienda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker_tienda)

        btn_salir.setOnClickListener {
            startTrackerActivityLogin()
        }
    }

    private fun startTrackerActivityLogin( ){
        val intent = Intent(this, LoginActivity :: class.java)
        startActivity(intent)
    }
}