package com.santi.pmdm.virgen.hospedaje.ui.views.fragment.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.santi.pmdm.virgen.hospedaje.databinding.FragmentDetailsHotelBinding
import com.santi.pmdm.virgen.hospedaje.ui.views.activities.MainActivity
import com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje.controler.ControllerDetailsHotel


class DetailsHotelFragment : Fragment() {

    lateinit var bindingFragment : FragmentDetailsHotelBinding
    val myArgument : DetailsHotelFragmentArgs by navArgs()
    private lateinit var controllerDetails : ControllerDetailsHotel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentDetailsHotelBinding.inflate(inflater, container, false)
        return bindingFragment.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        requireActivity().let {
            controllerDetails = (it as MainActivity).controllerDetailsHotel  //cargamos el controller.
            controllerDetails.setContextFragment(this)  //pasamos el contexto del Fragmento al controller
            controllerDetails.showDetails(myArgument.num)
        }

        //Toast.makeText(requireActivity()!!, "El hospedaje a mostrar es $numHospedaje", Toast.LENGTH_LONG).show()
    }


}