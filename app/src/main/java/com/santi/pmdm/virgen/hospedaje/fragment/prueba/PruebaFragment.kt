package com.santi.pmdm.virgen.hospedaje.fragment.prueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.databinding.FragmentPruebaBinding


class PruebaFragment : Fragment() {
    private lateinit var binding : FragmentPruebaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentPruebaBinding.inflate(inflater, container, false).root
    }


}