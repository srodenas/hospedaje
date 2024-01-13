package com.santi.pmdm.virgen.hospedaje.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.models.Hotel

class AdapterHotel(
    var listHotel : MutableList<Hotel>,
    var deleteOnClick: (Int) -> Unit,
    var updateOnClick: ( Int) -> Unit,
    var detailOnClick: (Int) -> Unit
) : RecyclerView.Adapter<ViewHHotel>(){
  /*
  Método que crea la view del ViewHolderHotel
   */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHHotel {
       val layoutInflater = LayoutInflater.from(parent.context)//objeto para crear la vista.
       val layoutItemHotel = R.layout.item_hotel  //accedo al xml del item a crear.
       return ViewHHotel(
           layoutInflater.inflate(layoutItemHotel, parent, false),
           deleteOnClick,
           updateOnClick,
           detailOnClick
       )
    }

    /*
    Este método, debe renderizar todos los datos o propiedades de cada hotel con la view.
    Accedemos al objeto por medio de position
     */
    override fun onBindViewHolder(holder: ViewHHotel, position: Int) {
        holder.renderize(listHotel.get(position), position)  //renderizamos la view.
     }

    /*
    Este método, devuelve el número de objetos a representar en el recyclerView.
     */
    override fun getItemCount(): Int = listHotel.size
}