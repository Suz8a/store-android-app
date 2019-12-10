package com.example.t.data.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Pedido(
    val folio: String,
    val cliente_id: String,
    val estado: String,
    val estado_tienda: String,
    val link_imagen: String,
    val link_imagen_taller: String
){
    class Deserializer: ResponseDeserializable<Array<Pedido>> {
        override fun deserialize(content: String): Array<Pedido>? = Gson().fromJson(content, Array<Pedido>::class.java)
    }
}