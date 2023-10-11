package com.santi.pmdm.virgen.hospedaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santi.pmdm.virgen.hospedaje.controler.Controller
import com.santi.pmdm.virgen.hospedaje.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var controller : Controller
    lateinit var binding : ActivityMainBinding
   // lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init() //inicializo la clase
    }

    fun init(){
        initRecyclerView()  //Cargamos el Layout al RecyclerView
        controller = Controller(this)  //Creamos el controler, encargado de todo.
        controller.setAdapter()  //cargamos el adapter. Encargado de adaptar los datos a las vistas.
        //controller.loggOut() //muestro el log en pantalla
    }

    private fun initRecyclerView() {
        /*
        layoutManager es el gestor responsable de posicionar los elementos (view) en un
        recyclerview. Como lo cargamos a partir de un LinearLayoutManager, los elementos los
        colocará uno debajo de otro (vertical). Automáticamente, aparecerá una barra de scroll que irá
        moviéndose con respecto a los elementos que se vayan insertando. Necesita el contexto del activity.
         */
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}