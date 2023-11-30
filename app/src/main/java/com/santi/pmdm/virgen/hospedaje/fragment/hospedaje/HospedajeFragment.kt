package com.santi.pmdm.virgen.hospedaje.fragment.hospedaje

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.santi.pmdm.virgen.hospedaje.MainActivity
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.controler.Controller
import com.santi.pmdm.virgen.hospedaje.databinding.FragmentHospedajeBinding

/*
Esta clase, será la que se encargue de cargar el recyclerView.
 */

class HospedajeFragment () : Fragment() {
   lateinit var bindigFragment: FragmentHospedajeBinding
    lateinit var controller : Controller
    lateinit var activityContext : Context


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContext = context as MainActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Creo el binding
        bindigFragment = FragmentHospedajeBinding.inflate(inflater, container, false)

        //inicializo el RecyclerView.
        initRecyclerView()

        // Inflo la vista del Fragmento.
        val viewFragment  = inflater.inflate(R.layout.fragment_hospedaje, container, false)

        //contexto del fragmento
        val contexto = context

        //creamos el controller
        controller = Controller(activityContext, this) //aseguro que no es null
        return viewFragment
    }



    /*
    Inicializo el RecyclerView. Forma que quiero que visualize las vistas.
     */
    private fun initRecyclerView() {
        bindigFragment.myRecyclerView.layoutManager = LinearLayoutManager(context as MainActivity)
    }


}