package com.santi.pmdm.virgen.hospedaje.ui.fragment.hospedaje

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.santi.pmdm.virgen.hospedaje.ui.MainActivity
import com.santi.pmdm.virgen.hospedaje.ui.fragment.hospedaje.controler.ControllerFragmentHotels
import com.santi.pmdm.virgen.hospedaje.databinding.FragmentHospedajeBinding

/*
Esta clase, será la que se encargue de cargar el recyclerView.
 */

class HospedajeFragment () : Fragment() {
    lateinit var bindigFragment: FragmentHospedajeBinding
    lateinit var controllerFragmentHotels : ControllerFragmentHotels



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


    /*
    UNA VEZ CREADA LA VISTA DEL FRAGMENTO Y ASEGURADA,
    INICIALIZO EL RECYCLERVIEW Y CREO EL CONTROLADOR, QUE GESTIONARÁ
    TODO LA LÓGICA
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //inicializo el ReciclerView
        bindigFragment.myRecyclerView.layoutManager = LinearLayoutManager(activity)
        requireActivity().let {
            controllerFragmentHotels = (it as MainActivity).controllerFragmentHotels  //cargamos el controller.
            controllerFragmentHotels.setContextFragment(this)  //pasamos el contexto del Fragmento al controller

        }
        //creamos el controller
       // controller = Controller(activity as MainActivity, this) //aseguro que no es null
        controllerFragmentHotels.initData()

    }
}