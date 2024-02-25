package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.HotelRepository
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel
import javax.inject.Inject

class UpdateHotelUseCase @Inject constructor(private val hotelRepository: HotelRepository) {
    private var updateHotel : Hotel? = null
    private  var updatePos : Int = 0

    fun setUpdatePos(_pos : Int){
        updatePos = _pos
    }

    fun setHotel(hotel : Hotel){
        updateHotel = hotel  //lo seteamos.
    }



    operator fun invoke(){
        hotelRepository.addHotel(updatePos, this.updateHotel!!)


    }
}