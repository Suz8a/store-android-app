package com.example.t.ui.login

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import android.content.Intent

import com.example.t.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val folio = findViewById<EditText>(R.id.folio)

        

            login.setOnClickListener {
                startTrackerActivity(folio.toString())
            }

        }



    private fun startTrackerActivity(folio: String ){
        val intent = Intent(this, Tracker :: class.java)
        intent.putExtra("folio", folio)

        startActivity(intent)
    }

    private fun startTrackerActivityTaller(){
        val intent = Intent(this, Tracker_taller :: class.java)
        startActivity(intent)
    }

    private fun startTrackerActivityTienda(){
        val intent = Intent(this, Tracker_tienda :: class.java)
        startActivity(intent)
    }
    private fun startTrackerActivityReporte(){
        val intent = Intent(this, Reporte :: class.java)
        startActivity(intent)
    }



}
