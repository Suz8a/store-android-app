package com.example.t.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import android.content.Intent
import android.util.Log

import com.example.t.R
import com.example.t.data.Api.ApiClient
import com.example.t.data.model.Cliente
import com.example.t.data.model.Pedido
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.await
import com.github.kittinunf.fuel.core.awaitResponse
import com.github.kittinunf.fuel.httpGet
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    var Clientes = ArrayList<Cliente>()

    //Request
    var dataList = ArrayList<Cliente>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        FuelManager.instance.basePath ="http://52.170.217.4/api/"

        val folio = findViewById<EditText>(R.id.folio)

        println("------------------------------------------------------------------------------------")

        getData()

            login.setOnClickListener {

                startTrackerActivityTaller(folio.text.toString())
                Toast.makeText(applicationContext,folio.text,Toast.LENGTH_LONG).show()
                println("============"+dataList.get(0).id)

            }


        }
    private fun getData() {
        val call: Call<List<Cliente>> = ApiClient.getClient.getClientes()
        call.enqueue(object : Callback<List<Cliente>> {

            override fun onResponse(call: Call<List<Cliente>>?, response: Response<List<Cliente>>?) {
                dataList.addAll(response!!.body()!!)
            }

            override fun onFailure(call: Call<List<Cliente>>?, t: Throwable?) {

            }

        })
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
