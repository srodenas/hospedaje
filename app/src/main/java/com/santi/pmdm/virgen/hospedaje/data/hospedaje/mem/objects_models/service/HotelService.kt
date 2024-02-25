package com.santi.pmdm.virgen.hospedaje.data.hospedaje.mem.objects_models.service

import com.santi.pmdm.virgen.hospedaje.data.hospedaje.mem.objects_models.RepositoryObjects
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HotelService @Inject constructor(){

    fun getNativeHotels(): List<Hotel>   = RepositoryObjects.listHotels

    fun getHotels(): List<Hotel> = ListHotel.hotels.hospedajes

    //Método que añade al repositorio un objeto de tipo Hotel. Devuelve la última posición.
    fun addHotel( pos : Int, hotel: Hotel) : Int{
        ListHotel.hotels.hospedajes.add(pos, hotel)
        return ListHotel.hotels.hospedajes.lastIndex

    }

    fun update(pos : Int, hotel: Hotel) {
        ListHotel.hotels.hospedajes.add(pos, hotel)
    }

    fun exisHotel( hotel : Hotel) : Boolean = ListHotel.hotels.hospedajes.contains(hotel)
    fun devHotelForPost(pos: Int): Hotel {
        return ListHotel.hotels.hospedajes.get(pos)
    }


    fun deleteHotel(pos: Int) {
        ListHotel.hotels.hospedajes.removeAt(pos)

    }
}