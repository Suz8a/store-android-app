package com.example.t.data.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Cliente(
    val id: String,
    val nombre: String,
    val apellido_materno: String,
    val apellido_paterno: String,
    val correo: String,
    val telefono: Int
){
    class Deserializer: ResponseDeserializable<Array<Cliente>> {
        override fun deserialize(content: String): Array<Cliente>? = Gson().fromJson(content, Array<Cliente>::class.java)
    }
}