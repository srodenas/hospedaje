package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.HotelRepository
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel

class NewHotelUseCase {
    private var newHotel : Hotel? = null

    fun setHotel(hotel : Hotel){
        newHotel = hotel  //lo seteamos.
    }



    operator fun invoke():Int{
        return if (!HotelRepository.myDao.exisHotel( this.newHotel!!)) {
            return HotelRepository.myDao.addHotel(ListHotel.hotels.hospedajes.size, this.newHotel!!)
        }else
            -1

    }
}