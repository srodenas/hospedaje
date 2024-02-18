package com.santi.pmdm.virgen.hospedaje.ui.viewmodel.hospedaje

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel

class HospedajeViewModel : ViewModel() {
    var hospedajeLiveData = MutableLiveData<List<Hotel>>()  //cualquier cambio en la lista de objetos.


}