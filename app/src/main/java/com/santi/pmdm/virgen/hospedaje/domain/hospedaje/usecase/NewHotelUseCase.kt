package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.HotelRepository
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel
import javax.inject.Inject

class NewHotelUseCase @Inject constructor(private val hotelRepository: HotelRepository){
    private var newHotel : Hotel? = null

    fun setHotel(hotel : Hotel){
        newHotel = hotel  //lo seteamos.
    }



    operator fun invoke():Int{
        return if (!hotelRepository.exisHotel( this.newHotel!!)) {
            return hotelRepository.addHotel(ListHotel.hotels.hospedajes.size, this.newHotel!!)
        }else
            -1

    }
}