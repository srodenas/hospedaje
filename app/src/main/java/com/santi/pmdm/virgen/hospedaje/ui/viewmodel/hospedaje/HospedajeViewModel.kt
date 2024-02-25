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
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HospedajeViewModel @Inject constructor(
            private val getAllHotelsUseCase: GetHotelsNativeUseCase ,
            private val newHotelUseCase: NewHotelUseCase,
            private val getHotelForPosUseCase: GetHotelForPosUseCase,
            private val deleteHotelUseCase: DeleteHotelUseCase,
            private val updateHotelUseCase: UpdateHotelUseCase,
            private val getHotelsUseCase: GetHotelsUseCase
)
     /*private val getHotelsUseCase: GetHotelsUseCase = GetHotelsUseCase(),
     private val newHotelUseCase: NewHotelUseCase = NewHotelUseCase(),
     private val getHotelForPosUseCase: GetHotelForPosUseCase = GetHotelForPosUseCase(),
     private val deleteHotelUseCase: DeleteHotelUseCase = DeleteHotelUseCase()
*/
  :  ViewModel(){
    var posNewHotelLiveData = MutableLiveData<Int>()
    var posDeleteHotelLiveDate = MutableLiveData<Int>()
    var posUpdateHotelLiveData = MutableLiveData<Int> ()
    var hotelsLiveData= MutableLiveData<MutableList<Hotel>>()
    /*private val getAllHotelsUseCase: GetHotelsNativeUseCase = GetHotelsNativeUseCase()
    private val newHotelUseCase: NewHotelUseCase = NewHotelUseCase()
    private val getHotelForPosUseCase: GetHotelForPosUseCase = GetHotelForPosUseCase()
    private val deleteHotelUseCase: DeleteHotelUseCase = DeleteHotelUseCase()
    private val updateHotelUseCase: UpdateHotelUseCase = UpdateHotelUseCase()
    private val getHotelsUseCase: GetHotelsUseCase = GetHotelsUseCase()

*/

    fun showHotels(){
        viewModelScope.launch {
            var data : MutableList<Hotel> ?

            if (ListHotel.hotels.hospedajes.isEmpty())
                data = getAllHotelsUseCase()
            else
                data = getHotelsUseCase()

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
               // showAllHotels()
                showHotels()
            }

        }

    }


    fun updateHotel(hotel: Hotel, pos : Int){
        viewModelScope.launch {
            deleteHotel(pos)
            posDeleteHotelLiveDate.value= pos
            updateHotelUseCase.setHotel(hotel)
            updateHotelUseCase.setUpdatePos(pos)
            updateHotelUseCase()
            posUpdateHotelLiveData.value = pos
           // showAllHotels()
            showHotels()
        }
    }


    fun deleteHotel(pos : Int){
        deleteHotelUseCase.setPos(pos)
        deleteHotelUseCase()
        posDeleteHotelLiveDate.value = pos
    //    showAllHotels()
        showHotels()
    }



    fun getHotelsForPosition(pos: Int) : Hotel{
        getHotelForPosUseCase.setPos(pos)
        val hotel = getHotelForPosUseCase()
        return hotel
    }

}