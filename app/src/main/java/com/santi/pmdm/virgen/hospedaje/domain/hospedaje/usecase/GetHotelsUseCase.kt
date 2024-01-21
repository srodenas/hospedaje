package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.data.hospedaje.dao.DaoHotels
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel

class GetHotelsUseCase {

    operator fun invoke(): MutableList<Hotel>{
        ListHotel.hotels.hospedajes = DaoHotels.myDao.getDataHotels().toMutableList()  //cargamos toda la lista de hoteles, en el singleton
        return ListHotel.hotels.hospedajes
    }
}