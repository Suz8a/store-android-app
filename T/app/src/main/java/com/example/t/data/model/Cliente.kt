package com.example.t.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Cliente(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("nombre")
    val nombre: String,
    @Expose
    @SerializedName("apellido_materno")
    val apellido_materno: String,
    @Expose
    @SerializedName("apellido_paterno")
    val apellido_paterno: String,
    @Expose
    @SerializedName("correo")
    val correo: String,
    @Expose
    @SerializedName("telefono")
    val telefono: Number
)