package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.HotelRepository

class DeleteHotelUseCase {
    private var pos : Int = 0

    fun setPos(_pos: Int){
        pos = _pos  //lo seteamos.
    }

    operator fun invoke(){
        HotelRepository.myDao.deleteHotel(pos)
    }
}