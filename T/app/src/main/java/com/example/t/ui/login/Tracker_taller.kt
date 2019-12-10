package com.example.t.ui.login

import com.squareup.picasso.Picasso;
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.t.R
import kotlinx.android.synthetic.main.activity_tracker_taller.*

class Tracker_taller : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val folio:String = intent.getStringExtra("folio")
        setContentView(R.layout.activity_tracker_taller)
        val image = findViewById<ImageView>(R.id.image)
        val imageUrl: String = "https://webdiag714.blob.core.windows.net/sampleimage/3e25fe7a-f8d2-43e2-ba42-69d6a5ea10b0-.jpg"

        Picasso.get().load(imageUrl).into(image)

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