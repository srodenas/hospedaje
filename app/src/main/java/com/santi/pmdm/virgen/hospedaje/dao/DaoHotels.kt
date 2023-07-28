package com.santi.pmdm.virgen.hospedaje.dao

import com.santi.pmdm.virgen.hospedaje.interfaces.InterfaceDao
import com.santi.pmdm.virgen.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.objects_models.Repository

class DaoHotels private constructor(): InterfaceDao {
    companion object {
        val myDao: DaoHotels by lazy{  //lazy delega a un primer acceso
            DaoHotels()  //Me creo sólo este objeto una vez.
        }
    }

    //Método que accede a la BBDD y devuelve todos los datos
    override
    fun getDataHotels(): List<Hotel>   = Repository.listHotels
}