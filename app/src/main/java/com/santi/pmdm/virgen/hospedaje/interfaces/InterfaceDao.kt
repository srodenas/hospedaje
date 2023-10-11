package com.santi.pmdm.virgen.hospedaje.interfaces

import com.santi.pmdm.virgen.hospedaje.models.Hotel

/*
Esta interfaz, es muy necesaria porque marga los métodos que deberá
tener un servicio en red. Puede ser:
1.- Repositorio en memoria ppal. Como este ejemplo
2.- Repositiorio desde una BBDD.
Marca los métodos que debe tener para independizar del resto de clases.
 */
interface InterfaceDao {
    fun getDataHotels(): List<Hotel>
  // fun getHotel(a:Int) : Hotel
  //  fun addHotel(hotel : Hotel) : Boolean

}