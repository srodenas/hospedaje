package com.santi.pmdm.virgen.hospedaje.domain.users.usecase

import com.santi.pmdm.virgen.hospedaje.domain.users.models.User
import com.santi.pmdm.virgen.hospedaje.domain.users.models.UserRepository
import javax.inject.Inject

class LoginUserCase  @Inject constructor(
    private val userRepository: UserRepository,
    private var posibleUser : User
){
    fun setUser(_posibleUser : User){
        posibleUser = _posibleUser
    }

    suspend operator fun invoke(): User ?{
        return (userRepository.getUser(posibleUser))
    }
}