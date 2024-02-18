package com.santi.pmdm.virgen.hospedaje.ui.viewmodel.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.User

class UserViewModel : ViewModel() {
    val login = MutableLiveData<Boolean>()


    fun isLogin(email : String, password : String) {
        //aquí hago la comprobaciòn de si existe algún usuario con esos datos.
        if (email.isEmpty() || password.isEmpty() || notExist(email, password))
            login.value = false
        else
            login.value = true
    }

    //Nos dice si ese usuario existe como usuario.
    private fun notExist(email: String, password: String): Boolean {
        return false
    }


}