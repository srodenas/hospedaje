package com.santi.pmdm.virgen.hospedaje.ui.viewmodel.hospedaje

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ListHotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.DeleteHotelUseCase
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.GetHotelForPosUseCase
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.GetHotelsNativeUseCase
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.GetHotelsUseCase
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.NewHotelUseCase
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.UpdateHotelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/*
1.- La consulta de acceso a datos asíncrona, la haremos en un hilo diferente al principal. Bien utilizar el de E/S.
2.- Las actualizaciones, las haremos en el mismo hilo principal. Todo lo que tenga que ver con LiveData.
 */
@HiltViewModel
class HospedajeViewModel @Inject constructor(
            private val getAllHotelsUseCase: GetHotelsNativeUseCase ,
            private val newHotelUseCase: NewHotelUseCase,
            private val getHotelForPosUseCase: GetHotelForPosUseCase,
            private val deleteHotelUseCase: DeleteHotelUseCase,
            private val updateHotelUseCase: UpdateHotelUseCase,
            private val getHotelsUseCase: GetHotelsUseCase
)

  :  ViewModel(){
    var posNewHotelLiveData = MutableLiveData<Int>()
    var posDeleteHotelLiveDate = MutableLiveData<Int>()
    var posUpdateHotelLiveData = MutableLiveData<Int> ()
    var hotelsLiveData= MutableLiveData<MutableList<Hotel>>()


    fun showHotels(){
        viewModelScope.launch(Dispatchers.IO)  {//Acceso a datos, en otro hilo diferente al principal.
            var data : MutableList<Hotel> ?

            if (ListHotel.hotels.hospedajes.isEmpty())
                data = getAllHotelsUseCase()
            else
                data = getHotelsUseCase()

            data.let { //Todo actualización del LiveData, se debe hacer en el principal.
                withContext(Dispatchers.Main) {
                    hotelsLiveData.value = it
                }
            }
        }
    }


    fun addHotel(hotel:Hotel){
        viewModelScope.launch(Dispatchers.IO) {
            newHotelUseCase.setHotel(hotel)
            var pos  = newHotelUseCase()
            if ( pos != -1){
                /*
                Lo que hacemos es al insertar un nuevo hotel, de la última posición del scroll (ultimo pueblo)
                hacemos un desplazamiento de 20 para que veamos el nuevo pueblo.

               Según la documentación, es interesante que la actualización de los LiveData, se haga en el hilo principal.
                */
                withContext(Dispatchers.Main) {//Con Dispatchers.Main, indicamos que el hilo se ejecute en el principal.
                    posNewHotelLiveData.value = pos
                }
                showHotels()
            }

        }

    }


    fun updateHotel(hotel: Hotel, pos : Int){
        viewModelScope.launch(Dispatchers.IO)  {
            deleteHotelUseCase.setPos(pos)
            deleteHotelUseCase()
            withContext(Dispatchers.Main) {
                posDeleteHotelLiveDate.value = pos
            }
            updateHotelUseCase.setHotel(hotel)
            updateHotelUseCase.setUpdatePos(pos)
            updateHotelUseCase()
            withContext(Dispatchers.Main) {
                posUpdateHotelLiveData.value = pos
            }
            showHotels()
        }
    }


    fun deleteHotel(pos : Int){
        deleteHotelUseCase.setPos(pos)
        deleteHotelUseCase()
        posDeleteHotelLiveDate.value = pos
        showHotels()
    }



    fun getHotelsForPosition(pos: Int) : Hotel{
        getHotelForPosUseCase.setPos(pos)
        val hotel = getHotelForPosUseCase()
        return hotel
    }

}