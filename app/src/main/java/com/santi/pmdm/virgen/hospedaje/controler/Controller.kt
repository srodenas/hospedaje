package com.santi.pmdm.virgen.hospedaje.controler

import android.content.Context
import android.widget.Toast
import com.santi.pmdm.virgen.hospedaje.dao.DaoHotels
import com.santi.pmdm.virgen.hospedaje.models.Hotel

/*
Clase qye controlará todos los eventos que se produzcan.
1.- Al crearse, llama al Dao y le devuelve todos los Hoteles. Lo inicializa
 */
class Controller (val context : Context){
    lateinit var listHotels : MutableList<Hotel>  //lista de objetos

    init {
        initData()
    }

    fun initData(){
       // listHotels = DaoHotels.dataService.toMutableList()
        listHotels = DaoHotels.myDao.getDataHotels().toMutableList()  //llamamos al singleton.
    }

    fun loggOut() {
        Toast.makeText(context, "He mostrado los datos en pantalla", Toast.LENGTH_LONG).show()
        listHotels.forEach{
            println (it)
        }
    }
}