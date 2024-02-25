package com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.santi.pmdm.virgen.hospedaje.ui.views.activities.MainActivity
import com.santi.pmdm.virgen.hospedaje.databinding.FragmentHospedajeBinding
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.ui.viewmodel.hospedaje.HospedajeViewModel
import com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje.adapter.AdapterHotel
import com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje.dialogues.DialogDeleteHotel
import com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje.dialogues.DialogEditHotel
import com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje.dialogues.DialogNewHotel
import dagger.hilt.android.AndroidEntryPoint

/*
Esta clase, será la que se encargue de cargar el recyclerView.
 */
@AndroidEntryPoint
class HospedajeFragment () : Fragment() {
    lateinit var bindigFragment: FragmentHospedajeBinding

    val hospedajeViewModel : HospedajeViewModel by viewModels()  //mi viewmodel

    private lateinit var layoutManager  : LinearLayoutManager
    lateinit var adapterHotel: AdapterHotel



    //CREO LA VISTA DEL FRAGMENTO
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Creo el binding y obtengo la view.
        bindigFragment = FragmentHospedajeBinding.inflate(inflater, container, false)
        val viewFragment = bindigFragment.root; //aquí tengo la view del fragment

        return viewFragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindigFragment.myRecyclerView.layoutManager = LinearLayoutManager(activity)
        setAdapter(mutableListOf()) //creamos el adapter, con datos vacíos.
        setObserver()       //observamos cambios en los datos.
        hospedajeViewModel.showHotels()//mostramos todos los hoteles o de forma nativa o con los que hemos estado trabajando en mem.
        btnAddOnClickListener()             //eventos
        setScrollWithOffsetLinearLayout()  //Necesitamos el LayoutManager para posicionar el offset del scroll
    }




    private fun setObserver() {
        hospedajeViewModel.hotelsLiveData.observe(viewLifecycleOwner,
            {
                    hotels->
                        updateAdapter(hotels)
            })


        //Se ha producido una actualización de la lista de Hoteles.
        hospedajeViewModel.posNewHotelLiveData.observe(viewLifecycleOwner,
            {
                    posNew->
                        adapterHotel.notifyItemInserted(posNew) //notificamos.
                        layoutManager.scrollToPositionWithOffset(posNew, 20)
            })


        hospedajeViewModel.posDeleteHotelLiveDate.observe(viewLifecycleOwner,
            {
                    posDel->
                        adapterHotel.notifyItemRemoved(posDel) //notificamos.
                        layoutManager.scrollToPositionWithOffset(posDel, 20)

            })

        hospedajeViewModel.posUpdateHotelLiveData.observe(viewLifecycleOwner,
            {
                    posUpdate ->
                        adapterHotel.notifyItemInserted(posUpdate)
                        layoutManager.scrollToPositionWithOffset(posUpdate, 20)
            })

    }



    fun setAdapter(hotels : MutableList<Hotel>) {
        adapterHotel =  AdapterHotel(  //creo el adapter y me lo guardo en una propiedad
            hotels,

            {
                    pos-> delHotel(pos) //eliminará el hotel seleccionado
            },

            {
                    pos-> updateHotel(pos) //actualizara el hotel seleccionado
            },

            {
                    pos -> details(pos)  //para los detalles del item
            }
        )
        this
            .bindigFragment
            .myRecyclerView.adapter = adapterHotel

    }


    //actualiza el adapter con los datos.
    fun updateAdapter(hotels : MutableList<Hotel>){
        adapterHotel.updateHotels(hotels)
    }


    /* -------- parte de la acción al nuevo hotel ------*/
    private fun btnAddOnClickListener() {
        bindigFragment.btnAdd.setOnClickListener{
            addHotel()
        }
    }

    fun addHotel(){
        Toast.makeText(context, "Añadiremos un nuevo hotel", Toast.LENGTH_LONG).show()
        val dialog = DialogNewHotel(){
                hotel -> okOnNewHotel(hotel)
        }
        val contexto = requireActivity()
        dialog.show(contexto.supportFragmentManager, "Añadimos un nuevo hotel")

    }
    //respuesta desde el dialogo. Aquí efectuamos la inserción.
    private fun okOnNewHotel(hotel: Hotel) {
        hospedajeViewModel.addHotel(hotel)
    }


    /* -------- Fin parte de la acción al nuevo hotel ------*/
    /* -------- Inicio de la acción a eliminar un hotel ----*/

    fun delHotel(pos : Int){
        val dialog = DialogDeleteHotel(
            pos,
            hospedajeViewModel.getHotelsForPosition(pos).name
        ){
                position -> okOnDeleteHotel(position)
        }

        dialog.show(requireActivity().supportFragmentManager, "Borraremos el hotel de posición $pos")
    }

    private fun okOnDeleteHotel(pos: Int) {
        hospedajeViewModel.deleteHotel(pos)  //eliminamos el hotel
    }

    /* ---------- Fin parte de la acción a la eliminación del hotel ------*/
    /* ---------- Comienzo parte acción a la actualización de un hotel ---*/

    fun updateHotel(pos: Int){

        val editDialog = DialogEditHotel(hospedajeViewModel.getHotelsForPosition(pos)){
                editHotel -> okOnEditHotel(editHotel, pos)
        }
        val contexto = requireActivity()
        editDialog.show(contexto.supportFragmentManager, "Editamos un hotel")


    }

    private fun okOnEditHotel(editHotel: Hotel, pos: Int) {

        hospedajeViewModel.updateHotel(editHotel, pos)
    }
    /* ---------- Fin parte de la acción a la actualización de un hotel --*/

    fun details(pos : Int){
        val contexto = requireActivity()
        Toast.makeText(contexto, "He pulsado los detalles de un item de posición $pos", Toast.LENGTH_LONG).show()
        val navController = this.findNavController()
        navController.navigate(HospedajeFragmentDirections.actionHospedajeFragmentToDetailsHotelFragment2(num = pos))
    }


    private fun setScrollWithOffsetLinearLayout() {

        if (bindigFragment.myRecyclerView.layoutManager is LinearLayoutManager){
            layoutManager = bindigFragment.myRecyclerView.layoutManager as LinearLayoutManager
        }

    }

}