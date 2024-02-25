package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel
import javax.inject.Inject

public class ShowDetallesUseCase @Inject constructor(){
    operator fun invoke(num: Int): Hotel{
       return ListHotel.hotels.hospedajes.get(num)
    }
}