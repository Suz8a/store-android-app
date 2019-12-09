package com.example.t.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.t.R
import kotlinx.android.synthetic.main.activity_tracker_taller.*

class Tracker_taller : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val folio:String = intent.getStringExtra("folio")
        setContentView(R.layout.activity_tracker_taller)

        btn_reporte.setOnClickListener{
            startTrackerActivityReporte(folio)
        }

        btn_salir.setOnClickListener{
            startTrackerActivityLogin()
        }

    }

    private fun startTrackerActivityReporte(folio: String ){
        val intent = Intent(this, Reporte :: class.java)
        intent.putExtra("folio", folio)
        startActivity(intent)
    }

    private fun startTrackerActivityLogin( ){
        val intent = Intent(this, LoginActivity :: class.java)
        startActivity(intent)
    }

}