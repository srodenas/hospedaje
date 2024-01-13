package com.santi.pmdm.virgen.hospedaje.fragment.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.databinding.FragmentHospedajeBinding


class DetailsHotelFragment : Fragment() {

    private lateinit var bindingFragment : FragmentHospedajeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentHospedajeBinding.inflate(inflater, container, false)
        return bindingFragment.root
    }

}