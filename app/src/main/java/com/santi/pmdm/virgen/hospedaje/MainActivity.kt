package com.santi.pmdm.virgen.hospedaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santi.pmdm.virgen.hospedaje.controler.Controller

class MainActivity : AppCompatActivity() {
    lateinit var controller : Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init() //inicializo la clase
    }

    fun init(){
        controller = Controller(this)  //Creamos el controler
        //controller.loggOut() //muestro el log en pantalla
    }
}