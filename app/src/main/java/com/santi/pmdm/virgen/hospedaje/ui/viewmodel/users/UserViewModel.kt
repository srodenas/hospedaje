package com.santi.pmdm.virgen.hospedaje.ui.viewmodel.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santi.pmdm.virgen.hospedaje.domain.users.models.User
import com.santi.pmdm.virgen.hospedaje.domain.users.usecase.LoginUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getLoginUseCaseProvider : Provider<LoginUserCase>

): ViewModel() {
    val login = MutableLiveData<Boolean>()




    fun isLogin(email: String, password: String) {
        viewModelScope.launch {
            //aquí hago la comprobaciòn de si existe algún usuario con esos datos.
            if (email.isEmpty() || password.isEmpty())
                login.value = false
            else {
                //  val user1 : User? = login(email, password)
                val posibleUser = User(email, password)
                val useCaseLogin =
                    getLoginUseCaseProvider.get() //aquí se crea una instancia del caso de uso para el login
                useCaseLogin.setUser(posibleUser)  //seteamos el posible usuario
                val user = useCaseLogin() //invocamos al usuario.
                if (user != null)
                    login.value = true
                else
                    login.value = false
            }
        }
    }
}





    //Nos dice si ese usuario existe como usuario.
   /* suspend fun login(email: String, password: String): User? {

        return withContext(Dispatchers.IO) {
            val posibleUser = User(email, password)
            val useCaseLogin = getLoginUseCaseProvider.get() //aquí se crea una instancia del caso de uso para el login
            useCaseLogin.setUser(posibleUser)  //seteamos el posible usuario
            val user = useCaseLogin() //invocamos al usuario.
            return@withContext user
        }
    }
*/






