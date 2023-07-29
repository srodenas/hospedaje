package com.santi.pmdm.virgen.hospedaje.controler

import android.content.Context
import android.widget.Toast
import com.santi.pmdm.virgen.hospedaje.MainActivity
import com.santi.pmdm.virgen.hospedaje.adapter.AdapterHotel
import com.santi.pmdm.virgen.hospedaje.dao.DaoHotels
import com.santi.pmdm.virgen.hospedaje.models.Hotel

/*
Clase qye controlará todos los eventos que se produzcan.
1.- Al crearse, llama al Dao y le devuelve todos los Hoteles. Lo inicializa
 */
class Controller (val context : Context){
    lateinit var listHotels : MutableList<Hotel>  //lista de objetos
    lateinit var adapterHotel: AdapterHotel


    init {
        initData()
    }

    fun initData(){
       // listHotels = DaoHotels.dataService.toMutableList()
        listHotels = DaoHotels.myDao.getDataHotels().toMutableList()  //llamamos al singleton.
        initOnClickListener()
    }

    /*
    Método que asigna el listener al botón de añadir.
     */
    private fun initOnClickListener() {
        val myActivity = context as MainActivity
        myActivity.binding.btnAdd.setOnClickListener {
            addHotel()
        }

    }

    fun loggOut() {
        Toast.makeText(context, "He mostrado los datos en pantalla", Toast.LENGTH_LONG).show()
        listHotels.forEach{
            println (it)
        }
    }

    fun setAdapter() {
        val myActivity = context as MainActivity

        adapterHotel =  AdapterHotel(  //creo el adapter y me lo guardo en una propiedad
            listHotels,

            {
                    pos-> delHotel(pos) //eliminará el hotel seleccionado
            },

            {
                    pos-> updateHotel(pos) //actualizara el hotel seleccionado
            }
        )
        myActivity.binding.myRecyclerView.adapter = adapterHotel


    }


    /*
    Actualiza un hotel, dado el actualizado
     */
    fun updateHotel(pos: Int){
        //Aquí habrá que crear un diálogo con los datos del hotel para modificar.
        Toast.makeText(context, "Actualizaremos el hotel de posición $pos", Toast.LENGTH_LONG).show()
    }


    /*
    Añade un nuevo hotel.
     */
    fun addHotel(){
        Toast.makeText(context, "Añadiremos un nuevo hotel", Toast.LENGTH_LONG).show()

    }


    /*
    Elimina un hotel, dado su posición.
     */
    fun delHotel(pos : Int){
        //Aquí habrá que crear un diáglogo para borrar el hotel
        Toast.makeText(context, "Borraremos el hotel de posición $pos", Toast.LENGTH_LONG).show()
        listHotels.removeAt(pos)
        adapterHotel.notifyItemRemoved(pos)  //Notificamos sólo a esa posición


    }
}