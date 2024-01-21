package com.santi.pmdm.virgen.hospedaje.data.hospedaje.dao

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.interfaces.InterfaceDao
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel
import com.santi.pmdm.virgen.hospedaje.data.hospedaje.objects_models.Repository

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
class DaoHotels private constructor(): InterfaceDao {
    companion object {
        /*
        by lazy, quiere decir que si hacemos referencia a myDao por primera vez, al tener una
        lambda, ejecutará su lógica. Si volvemos a referenciarlo otra vez, NOOOO ejecutará la lógica
        de la lambda.
         */
        val myDao: DaoHotels by lazy{  //lazy delega a un """PRIMER ACCESO""""
            DaoHotels()  //Me creo sólo este objeto una vez.
        }
    }

    //Método que accede al repositorio y devuelve todos los datos
    override
    fun getDataHotels(): List<Hotel>   = Repository.listHotels
}