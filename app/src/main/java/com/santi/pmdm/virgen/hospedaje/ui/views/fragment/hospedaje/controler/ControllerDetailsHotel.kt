package com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje.controler

import android.content.Context
import com.bumptech.glide.Glide
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.ShowDetallesUseCase
import com.santi.pmdm.virgen.hospedaje.ui.views.fragment.details.DetailsHotelFragment

class ControllerDetailsHotel(val context : Context) {
    private lateinit var contextFragment: DetailsHotelFragment
    val showDetailsUseCase = ShowDetallesUseCase()


    fun setContextFragment(context: DetailsHotelFragment){
        contextFragment = context
    }

    fun showDetails(num: Int) {
       val hotel = showDetailsUseCase(num)
        updateViewDetailsHotel(hotel)
    }

    private fun updateViewDetailsHotel(hotel: Hotel) {
        contextFragment.bindingFragment.txtviewName.setText(hotel.name)
        contextFragment.bindingFragment.txtviewCity.setText(hotel.city)
        contextFragment.bindingFragment.txtviewProvince.setText(hotel.province)
        contextFragment.bindingFragment.txtviewPhone.setText(hotel.phone)
        Glide
            .with(contextFragment)
            .load(hotel.image)
            .centerCrop()
            .into(contextFragment.bindingFragment.ivHotel)
        contextFragment.bindingFragment.textDetails.text= hotel.description



    }
}