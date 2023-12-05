package com.santi.pmdm.virgen.hospedaje.fragment.hospedaje

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santi.pmdm.virgen.hospedaje.MainActivity
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.adapter.AdapterHotel
import com.santi.pmdm.virgen.hospedaje.controler.Controller
import com.santi.pmdm.virgen.hospedaje.dao.DaoHotels
import com.santi.pmdm.virgen.hospedaje.databinding.FragmentHospedajeBinding
import com.santi.pmdm.virgen.hospedaje.dialogues.DialogDeleteHotel
import com.santi.pmdm.virgen.hospedaje.dialogues.DialogEditHotel
import com.santi.pmdm.virgen.hospedaje.dialogues.DialogNewHotel
import com.santi.pmdm.virgen.hospedaje.models.Hotel

/*
Esta clase, será la que se encargue de cargar el recyclerView.
 */

class HospedajeFragment () : Fragment() {
    lateinit var bindigFragment: FragmentHospedajeBinding
    lateinit var controller : Controller
    //lateinit var activityContext : Context

   /* override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContext = context as MainActivity
    }
    */

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

        //creamos el controller
        controller = Controller(activity as MainActivity, this) //aseguro que no es null

    }
}