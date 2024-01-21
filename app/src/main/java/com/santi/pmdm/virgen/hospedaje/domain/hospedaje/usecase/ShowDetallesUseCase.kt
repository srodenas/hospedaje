package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel

public class ShowDetallesUseCase {
    operator fun invoke(num: Int): Hotel{
       return ListHotel.hotels.hospedajes.get(num)
    }
}