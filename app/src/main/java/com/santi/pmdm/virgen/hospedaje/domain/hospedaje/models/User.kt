package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models

/*
Modelo para el usuario registrado
 */
data class User(var id: Int, var email:String, var passw:String, val disponible: Boolean, var imagen: String){

}
