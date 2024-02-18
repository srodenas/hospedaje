package com.santi.pmdm.virgen.hospedaje.ui.viewmodel.hospedaje

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.DeleteHotelUseCase
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.GetHotelForPosUseCase
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.GetHotelsUseCase
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.usecase.NewHotelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


//@HiltViewModel
class HospedajeViewModel
     /*private val getHotelsUseCase: GetHotelsUseCase = GetHotelsUseCase(),
     private val newHotelUseCase: NewHotelUseCase = NewHotelUseCase(),
     private val getHotelForPosUseCase: GetHotelForPosUseCase = GetHotelForPosUseCase(),
     private val deleteHotelUseCase: DeleteHotelUseCase = DeleteHotelUseCase()
*/
  :  ViewModel(){
    var posNewHotelLiveData = MutableLiveData<Int>()
    var posDeleteHotelLiveDate = MutableLiveData<Int>()
    var hotelsLiveData= MutableLiveData<MutableList<Hotel>>()
    private val getHotelsUseCase: GetHotelsUseCase = GetHotelsUseCase()
    private val newHotelUseCase: NewHotelUseCase = NewHotelUseCase()
    private val getHotelForPosUseCase: GetHotelForPosUseCase = GetHotelForPosUseCase()
    private val deleteHotelUseCase: DeleteHotelUseCase = DeleteHotelUseCase()




    fun showHotels2(){
        viewModelScope.launch {
            var data : MutableList<Hotel> ? = getHotelsUseCase()
            data.let {
                hotelsLiveData.value = it
            }

        }

    }

    fun addHotel(hotel:Hotel){
        viewModelScope.launch {
            newHotelUseCase.setHotel(hotel)
            var pos  = newHotelUseCase()
            if ( pos != -1){
                /*
                Lo que hacemos es al insertar un nuevo hotel, de la última posición del scroll (ultimo pueblo)
                hacemos un desplazamiento de 20 para que veamos el nuevo pueblo.
                 */
                posNewHotelLiveData.value = pos

            }

        }

    }





    fun deleteHotel(pos : Int){
        deleteHotelUseCase.setPos(pos)
        deleteHotelUseCase()
        posDeleteHotelLiveDate.value = pos

    }



    fun getHotelsForPosition(pos: Int) : Hotel{

        getHotelForPosUseCase.setPos(pos)
        val hotel = getHotelForPosUseCase()
        return hotel
    }


}