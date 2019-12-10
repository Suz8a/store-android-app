package com.example.t.data.Interfaces

import com.example.t.data.model.Pedido
import retrofit2.Call
import retrofit2.http.GET

interface ApiPedidoInterface {
    @GET("pedido")
    fun getPedidos(): Call<List<Pedido>>
}