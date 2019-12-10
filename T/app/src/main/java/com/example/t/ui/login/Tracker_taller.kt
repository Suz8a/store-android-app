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
        val imgUrl:String = intent.getStringExtra("imgUrl")
        setContentView(R.layout.activity_tracker_taller)
        val image = findViewById<ImageView>(R.id.image)
        val imageUrl: String = imgUrl

        Picasso.get().load(imageUrl).into(image)

        btn_reporte.setOnClickListener{
            startTrackerActivityReporte(imgUrl)
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