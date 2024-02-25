package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.interfaces

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel

/*
Esta interfaz, es muy necesaria porque marga los métodos que deberá
tener un servicio en red. Puede ser:
1.- Repositorio en memoria ppal. Como este ejemplo
2.- Repositiorio desde una BBDD.
Marca los métodos que debe tener para independizar del resto de clases.
 */
interface InterfaceDao {
    fun getNativeHotels(): List<Hotel>
   fun deleteHotel(a:Int)
    fun addHotel(  pos: Int, hotel : Hotel): Int

    fun update(pos : Int, hotel: Hotel)

    fun exisHotel(hotel : Hotel) : Boolean

    fun devHotelForPost(pos : Int): Hotel

}