package com.santi.pmdm.virgen.hospedaje.domain.users.models

import com.santi.pmdm.virgen.hospedaje.data.hospedaje_users.network.models.Request.RequestLoginUser
import com.santi.pmdm.virgen.hospedaje.data.hospedaje_users.network.service.HospedajeApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: HospedajeApiService
){

    suspend fun getUser(user : User) : User? {
        val userRequest = RequestLoginUser(user.email, user.passw)
        val result = apiService.getUser(userRequest)
        result
            .onSuccess {
                responseUser->
                    return User(

                        responseUser.id,
                        responseUser.token,
                        responseUser.email,
                        "",
                        1,
                     //   responseUser.passw,
                      //  responseUser.disponible,
                        responseUser.image)

        }
            .onFailure {
                exception ->  println(" ${exception.message}")
            }
        return null
    }
}