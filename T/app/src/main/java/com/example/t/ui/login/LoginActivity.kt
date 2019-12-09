package com.example.t.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import android.content.Intent

import com.example.t.R
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val folio = findViewById<EditText>(R.id.folio)

        Fuel.get("http://52.170.217.4/api/pedido")
            .response { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    println("[response bytes] ${String(bytes)}")
                }
            }



            login.setOnClickListener {
                startTrackerActivityTaller(folio.text.toString())
                Toast.makeText(applicationContext,folio.text,Toast.LENGTH_LONG).show()
            }

        }



    private fun startTrackerActivity(){
        val intent = Intent(this, Tracker :: class.java)
        startActivity(intent)
    }

    private fun startTrackerActivityTienda(){
        val intent = Intent(this, Tracker_tienda :: class.java)
        startActivity(intent)
    }

    private fun startTrackerActivityTaller(folio: String ){
        val intent = Intent(this, Tracker_taller :: class.java)
        intent.putExtra("folio", folio)
        startActivity(intent)
    }



}
