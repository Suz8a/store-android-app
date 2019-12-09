package com.example.t.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t.R
import kotlinx.android.synthetic.main.activity_tracker_taller.*

class Tracker : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)

        btn_salir.setOnClickListener {
            startTrackerActivityLogin()
        }

    }

    private fun startTrackerActivityLogin( ){
        val intent = Intent(this, LoginActivity :: class.java)
        startActivity(intent)
    }

}


