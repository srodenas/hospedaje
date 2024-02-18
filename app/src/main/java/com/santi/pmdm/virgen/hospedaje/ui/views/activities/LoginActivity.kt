package com.santi.pmdm.virgen.hospedaje.ui.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.databinding.ActivityLoginBinding
import com.santi.pmdm.virgen.hospedaje.databinding.ActivityMainBinding
import com.santi.pmdm.virgen.hospedaje.ui.viewmodel.users.UserViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    val userViewModel : UserViewModel by viewModels()  //viewModel del Usuario.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerLiveData()
        initEvent()
    }

    private fun initEvent() {
        binding.btnLogin.setOnClickListener{
            userViewModel.isLogin(binding.txtEmail.text.toString(), binding.txtPassword.text.toString())

        }
        binding.btnRegistro.setOnClickListener{

        }
    }

    private fun registerLiveData() {
        userViewModel.login.observe(this, {
            login->
            if (login) {
                //aquí tengo que lanzar el activity ppal.
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Error en el logueo", Toast.LENGTH_LONG).show()
            }
        } )
    }
}