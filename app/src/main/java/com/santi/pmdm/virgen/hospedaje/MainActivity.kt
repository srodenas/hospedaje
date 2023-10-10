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
        initRecyclerView()
        controller = Controller(this)  //Creamos el controler
        controller.setAdapter()  //cargamos el adapter.
        //controller.loggOut() //muestro el log en pantalla
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}