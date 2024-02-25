package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.HotelRepository
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel
import javax.inject.Inject

class GetHotelsNativeUseCase @Inject constructor(private val hotelRepository: HotelRepository){

    operator fun invoke(): MutableList<Hotel>?{
        ListHotel.hotels.hospedajes = hotelRepository.getNativeHotels().toMutableList()  //cargamos toda la lista de hoteles, en el singleton
        return ListHotel.hotels.hospedajes
    }
}