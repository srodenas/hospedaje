package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.interfaces

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel


interface InterfaceOnClickDialog {
    fun onEditHotelDialog(hotel: Hotel, pos: Int)
    fun onAddHotelDialog(hotel : Hotel)
    fun onDeleteHotelDialog(pos : Int)
}