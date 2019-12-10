package com.example.t.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Pedido(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("folio")
    val folio: String,
    @Expose
    @SerializedName("contrasena")
    val contrasena: String,
    @Expose
    @SerializedName("servicio")
    val servicio: String,
    @Expose
    @SerializedName("descripcion")
    val descripcion: String,
    @Expose
    @SerializedName("estado")
    val estado: String,
    @Expose
    @SerializedName("estado_tienda")
    val estado_tienda: String,
    @Expose
    @SerializedName("estado_taller")
    val estado_taller: String,
    @Expose
    @SerializedName("link_imagen")
    val link_imagen: String,
    @Expose
    @SerializedName("link_imagen_taller")
    val link_imagen_taller: String,
    @Expose
    @SerializedName("cliente_id")
    val cliente_id: String,
    @Expose
    @SerializedName("usuario_id")
    val usuario_id: String,
    @Expose
    @SerializedName("ticker_id")
    val ticker_id: String,
    @Expose
    @SerializedName("joya")
    val joya: JoyaObj,
    @Expose
    @SerializedName("material_adjunto")
    val material_adjunto: Array<MaterialAdjuntoObj>,
    @Expose
    @SerializedName("material_utilizar")
    val material_utilizar: Array<MaterialUtilizarObj>,
    @Expose
    @SerializedName("presupuesto")
    val presupuesto: PresupuestoObj

)

data class JoyaObj(
    @Expose
    @SerializedName("nombre_joya")
    val nombre_joya: String,
    @Expose
    @SerializedName("peso_joya")
    val peso_joya: Number,
    @Expose
    @SerializedName("medida_inicial")
    val medida_inicial: Number?,
    @Expose
    @SerializedName("medida_final")
    val medida_final: Number?
)

data class MaterialAdjuntoObj(
    @Expose
    @SerializedName("nombre_material")
    val nombre_material: String,
    @Expose
    @SerializedName("gramos")
    val gramos: Number
)

data class MaterialUtilizarObj(
    @Expose
    @SerializedName("nombre_material")
    val nombre_material: String,
    @Expose
    @SerializedName("gramos")
    val gramos: Number,
    @Expose
    @SerializedName("precio")
    val precio: Number
)

data class PresupuestoObj(
    @Expose
    @SerializedName("hechura")
    val hechura: String,
    @Expose
    @SerializedName("gramos")
    val total: Number
)














