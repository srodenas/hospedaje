package com.santi.pmdm.virgen.hospedaje.data.hospedaje.dao

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.data.hospedaje.objects_models.Repository

/*   OTRA FORMA DE HACER UN SINGLETON
Queremos hacer un singleton.
Simulamos un acceso por Dao a una BBDD.
 */
object DaoHotels2 {

    val dataService by lazy {
        getDataHotels()
    }

    private fun getDataHotels() : List<Hotel> = Repository.listHotels
}