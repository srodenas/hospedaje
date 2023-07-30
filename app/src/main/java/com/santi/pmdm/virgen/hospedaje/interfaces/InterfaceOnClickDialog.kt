package com.santi.pmdm.virgen.hospedaje.interfaces

import com.santi.pmdm.virgen.hospedaje.models.Hotel

interface InterfaceOnClickDialog {
    fun onEditHotelDialog(hotel: Hotel, pos: Int)
    fun onAddHotelDialog(hotel : Hotel)
    fun onDeleteHotelDialog(pos : Int)
}