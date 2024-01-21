package com.santi.pmdm.virgen.hospedaje.ui.fragment.hospedaje.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.santi.pmdm.virgen.hospedaje.databinding.ItemHotelBinding
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel

/*
Recibe la vista creada por el adaptador y mapeo de los datos en la vista.
 */
class ViewHHotel(view: View,
                var deleteOnClick: (Int) -> Unit,
                 var updateOnClick: (Int) -> Unit,
                 var detailOnClick: (Int) -> Unit

) : RecyclerView.ViewHolder (view){
    lateinit var binding: ItemHotelBinding

    init {
        binding = ItemHotelBinding.bind(view)
    }


    //método que se encarga de mapear los item por propiedad del modelo.
    fun renderize(hotel : Hotel, position : Int){
        binding.txtviewName.setText(hotel.name)
        binding.txtviewCity.setText(hotel.city)
        binding.txtviewProvince.setText(hotel.province)
        binding.txtviewPhone.setText(hotel.phone)
        Glide
            .with(itemView.context)
            .load(hotel.image)
            .centerCrop()
            .into(binding.ivHotel)

        setOnClickListener(position) //inicia los listener para los botones.
    }

    private fun setOnClickListener(position : Int) {

        binding.btnEdit.setOnClickListener {
            updateOnClick(position )
        }

        binding.btnDelete.setOnClickListener{
            deleteOnClick(position)
        }

        binding.btnDetail.setOnClickListener{
            detailOnClick(position)
        }
    }
}