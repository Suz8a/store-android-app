package com.example.t.data.Interfaces

import com.example.t.data.model.Cliente
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("cliente")
    fun getClientes(): Call<List<Cliente>>

}