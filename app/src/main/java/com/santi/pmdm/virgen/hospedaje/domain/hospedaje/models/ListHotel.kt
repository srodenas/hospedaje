package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models

public class ListHotel private constructor(
){
    var hospedajes: MutableList<Hotel> = mutableListOf()
    companion object {
        val hotels : ListHotel by lazy{
            ListHotel()
        }

    }

}