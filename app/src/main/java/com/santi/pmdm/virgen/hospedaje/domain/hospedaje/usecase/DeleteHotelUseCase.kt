package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.HotelRepository
import javax.inject.Inject

class DeleteHotelUseCase @Inject constructor(private val hotelRepository: HotelRepository) {
    private var pos : Int = 0

    fun setPos(_pos: Int){
        pos = _pos  //lo seteamos.
    }

    operator fun invoke(){
        hotelRepository.deleteHotel(pos)
    }
}