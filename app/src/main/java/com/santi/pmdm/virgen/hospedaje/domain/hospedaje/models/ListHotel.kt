package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models

import com.santi.pmdm.virgen.hospedaje.data.hospedaje.dao.DaoHotels

public class ListHotel private constructor(
){
    var hospedajes: MutableList<Hotel> = mutableListOf()
    companion object {
        val hotels : ListHotel by lazy{
            ListHotel()
        }

    }

}