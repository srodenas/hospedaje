package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.interfaces.InterfaceDao
import com.santi.pmdm.virgen.hospedaje.data.hospedaje.mem.objects_models.RepositoryObjects

/*
Es interesante ver como definimos un constructor privado por defecto, para
que no podamos crearmos un objeto de tipo DaoHotels fuera de este fichero.
El constructor, sólo lo creará una lambda de una variable estática.
Es decir, un companion object, es la forma de declarar variables y métodos estáticos como en Java.
 Kotlin no tiene la palabra static, pero si la palabra companion object. Todo
lo que declaremos dentro del companion object, se considera estático.
Su expresión lambda,
será la encargada de crear el constructor de DaoHotels como objeto único que tendremos que tener
en toda la aplicación.
Es curioso el método by lazy. Eso quiere decir, que la primera vez que se acceda a myDao, se ejecutará todo
el código de la lambda. Si volvemos a ejecutarlo por segunda/tercera/etc vez, no se ejecutará el código de la
lambda.
 */
class HotelRepository private constructor(): InterfaceDao {
    companion object {
        /*
        by lazy, quiere decir que si hacemos referencia a myDao por primera vez, al tener una
        lambda, ejecutará su lógica. Si volvemos a referenciarlo otra vez, NOOOO ejecutará la lógica
        de la lambda.
         */
        val myDao: HotelRepository by lazy{  //lazy delega a un """PRIMER ACCESO""""
            HotelRepository()  //Me creo sólo este objeto una vez.
        }
    }

    //Método que accede al repositorio y devuelve todos los datos
    override
    fun getDataHotels(): List<Hotel>   = RepositoryObjects.listHotels



    //Método que añade al repositorio un objeto de tipo Hotel. Devuelve la última posición.
    override fun addHotel( pos : Int, hotel: Hotel) : Int{
        ListHotel.hotels.hospedajes.add(pos, hotel)
        return ListHotel.hotels.hospedajes.lastIndex

    }

    override fun exisHotel( hotel : Hotel) : Boolean = ListHotel.hotels.hospedajes.contains(hotel)
    override fun devHotelForPost(pos: Int): Hotel {
        return ListHotel.hotels.hospedajes.get(pos)
    }


    override fun deleteHotel(pos: Int) {
        ListHotel.hotels.hospedajes.removeAt(pos)

    }


}