package com.santi.pmdm.virgen.hospedaje.interfaces

import com.santi.pmdm.virgen.hospedaje.models.Hotel

interface InterfaceDao {
    fun getDataHotels(): List<Hotel>
  // fun getHotel(a:Int) : Hotel
  //  fun addHotel(hotel : Hotel) : Boolean

}