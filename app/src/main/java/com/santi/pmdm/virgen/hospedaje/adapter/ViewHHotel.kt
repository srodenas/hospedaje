package com.santi.pmdm.virgen.hospedaje.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.santi.pmdm.virgen.hospedaje.databinding.ItemHotelBinding
import com.santi.pmdm.virgen.hospedaje.models.Hotel

/*
Recibe la vista creada por el adaptador y mapeo de los datos en la vista.
 */
class ViewHHotel (view: View) : RecyclerView.ViewHolder (view){
    lateinit var binding: ItemHotelBinding

    init {
        binding = ItemHotelBinding.bind(view)
    }


    //método que se encarga de mapear los item por propiedad del modelo.
    fun renderize(hotel : Hotel){
        binding.txtviewName.setText(hotel.name)
        binding.txtviewCity.setText(hotel.city)
        binding.txtviewProvince.setText(hotel.province)
        binding.txtviewPhone.setText(hotel.phone)
        Glide
            .with(itemView.context)
            .load(hotel.image)
            .centerCrop()
            .into(binding.ivHotel)
    }
}