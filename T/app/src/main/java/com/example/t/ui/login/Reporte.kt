package com.example.t.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.t.R
import kotlinx.android.synthetic.main.activity_reporte.*
import kotlinx.android.synthetic.main.activity_tracker_taller.*
import kotlinx.android.synthetic.main.activity_tracker_taller.btn_salir

class Reporte : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val folio:String = intent.getStringExtra("folio")
        setContentView(R.layout.activity_reporte)

        btn_salir.setOnClickListener {
            startTrackerActivityLogin()
        }

        btn_cancelar_reporte.setOnClickListener {
            finish();
        }

    }

    private fun startTrackerActivityLogin( ){
        val intent = Intent(this, LoginActivity :: class.java)
        startActivity(intent)
    }
}