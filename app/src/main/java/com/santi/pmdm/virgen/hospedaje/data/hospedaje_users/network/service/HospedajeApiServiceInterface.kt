package com.santi.pmdm.virgen.hospedaje.data.hospedaje_users.network.service

import com.santi.pmdm.virgen.hospedaje.data.hospedaje_users.network.models.Request.RequestLoginUser
import com.santi.pmdm.virgen.hospedaje.data.hospedaje_users.network.models.Responses.ResponseLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface HospedajeApiServiceInterface {

    @POST("auth")
    suspend fun login(@Body loginUser : RequestLoginUser): Response<ResponseLogin>


}