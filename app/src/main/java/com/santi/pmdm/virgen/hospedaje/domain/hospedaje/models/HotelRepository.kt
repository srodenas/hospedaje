package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models


import com.santi.pmdm.virgen.hospedaje.data.hospedaje.mem.objects_models.service.HotelService
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.interfaces.InterfaceDao
import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class HotelRepository @Inject constructor(private val hotelService : HotelService): InterfaceDao {

    //Método que accede al repositorio y devuelve todos los datos
    override
    fun getNativeHotels(): List<Hotel>   = hotelService.getNativeHotels()//RepositoryObjects.listHotels


    //Devuelve los hoteles actuales.
    fun getHotels(): List<Hotel> = hotelService.getHotels()



    //Método que añade al repositorio un objeto de tipo Hotel. Devuelve la última posición.
    override fun addHotel( pos : Int, hotel: Hotel) : Int{
        return hotelService.addHotel(pos, hotel)


    }

    override fun update(pos : Int, hotel: Hotel) {
        hotelService.update(pos, hotel)
    }

    override fun exisHotel( hotel : Hotel) : Boolean = hotelService.exisHotel(hotel)


    override fun devHotelForPost(pos: Int): Hotel {
        return hotelService.devHotelForPost(pos)
    }


    override fun deleteHotel(pos: Int) {
        hotelService.deleteHotel(pos)

    }


}