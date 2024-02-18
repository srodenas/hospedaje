package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.HotelRepository
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel

class GetHotelForPosUseCase {
    private var pos : Int = 0

    fun setPos(_pos: Int){
        pos = _pos  //lo seteamos.
    }

    operator fun invoke(): Hotel  = HotelRepository.myDao.devHotelForPost(pos)


}