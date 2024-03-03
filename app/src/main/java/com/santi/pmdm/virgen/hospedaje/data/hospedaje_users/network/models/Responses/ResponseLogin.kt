package com.santi.pmdm.virgen.hospedaje.data.hospedaje_users.network.models.Responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
Realmente, sólo hace falta serializar los que son diferentes en la api, pero recomendable.
 */
data class ResponseLogin (

    @SerializedName("result")
    @Expose
    val result: String,

    @SerializedName("token")
    @Expose
    val token : String,

    @SerializedName("id")
    @Expose
    val id : Int,

    @SerializedName("nombre")
    @Expose
    val name : String,

    @SerializedName("email")
    @Expose
    val email : String,

   /* @SerializedName("password")
    @Expose
    val passw : String,

    @SerializedName("disponible")
    @Expose
    val disponible : Int,
*/
    @SerializedName("imagen")
    @Expose
    val image : String
    ){
}