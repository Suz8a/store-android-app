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


    //Request
    var clientes = ArrayList<Cliente>()
    var pedidos = ArrayList<Pedido>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        FuelManager.instance.basePath ="http://52.170.217.4/api/"

        val folio = findViewById<EditText>(R.id.folio)





            login.setOnClickListener {
                getDataPedidos()
                getDataClientes()

                val folioPedido = folio.text.toString()
                var estadoTaller:String = ""
                var estadoTienda:String =""
                var estado:String = ""
                var imgUrl:String =""

                for ( item in pedidos ){
                    if(item.folio.equals(folioPedido)){
                        estadoTaller = item.estado_taller
                        estadoTienda = item.estado_tienda
                        estado = item.estado
                        imgUrl = item.link_imagen_taller
                    }

                }

                if(estado.equals("En proceso"))
                    startTrackerActivity()
                if(estadoTienda.equals("Recibir joya")  && estadoTaller.equals("Recibir joya"))
                    startTrackerActivity()
                if(estadoTienda.equals("Recibir joya")  && estadoTaller.equals("Enviar joya") && estado.equals("En taller") )
                    startTrackerActivity()
                if(estadoTaller.equals("Terminado") && estadoTienda.equals("Recibir joya") )
                    startTrackerActivityTaller(imgUrl)
                if(estadoTienda.equals("Entregar joya") && estadoTaller.equals("Terminado") )
                    startTrackerActivityTienda()



                println("FOLIOOOOOOOO  "+folioPedido)


            }


        }

    private fun getDataPedidos() {
        val call: Call<List<Pedido>> = ApiClient.getPedido.getPedidos()
        call.enqueue(object : Callback<List<Pedido>> {

            override fun onResponse(call: Call<List<Pedido>>?, response: Response<List<Pedido>>?) {
                pedidos.addAll(response!!.body()!!)
            }

            override fun onFailure(call: Call<List<Pedido>>?, t: Throwable?) {

            }

        })
    }

    private fun getDataClientes() {
        val call: Call<List<Cliente>> = ApiClient.getClient.getClientes()
        call.enqueue(object : Callback<List<Cliente>> {

            override fun onResponse(call: Call<List<Cliente>>?, response: Response<List<Cliente>>?) {
                clientes.addAll(response!!.body()!!)
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

    private fun startTrackerActivityTaller(imgUrl: String ){
        val intent = Intent(this, Tracker_taller :: class.java)
        intent.putExtra("imgUrl", imgUrl)
        startActivity(intent)
    }



}
