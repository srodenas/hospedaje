package com.santi.pmdm.virgen.hospedaje.controler

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.santi.pmdm.virgen.hospedaje.MainActivity
import com.santi.pmdm.virgen.hospedaje.adapter.AdapterHotel
import com.santi.pmdm.virgen.hospedaje.dao.DaoHotels
import com.santi.pmdm.virgen.hospedaje.dao.DaoHotels2
import com.santi.pmdm.virgen.hospedaje.dialogues.DialogDeleteHotel
import com.santi.pmdm.virgen.hospedaje.dialogues.DialogEditHotel
import com.santi.pmdm.virgen.hospedaje.dialogues.DialogNewHotel
import com.santi.pmdm.virgen.hospedaje.models.Hotel

/*
Clase qye controlará todos los eventos que se produzcan.
1.- Al crearse, llama al Dao y le devuelve todos los Hoteles. Lo inicializa
 */
class Controller (val context : Context){
    lateinit var listHotels : MutableList<Hotel>  //lista de objetos
    lateinit var adapterHotel: AdapterHotel
    private lateinit var layoutManager  : LinearLayoutManager




    init {
        initData()
    }

    fun initData(){
       // listHotels = DaoHotels.dataService.toMutableList()
        setScrollWithOffsetLinearLayout()  //Necesitamos el LayoutManager para posicionar el offset del scroll
        listHotels = DaoHotels.myDao.getDataHotels().toMutableList()  //llamamos al singleton.
       // listHotels = DaoHotels.myDao.getDataHotels().toMutableList()  //llamamos al singleton.

        //listHotels = DaoHotels2.dataService.toMutableList()  //llamamos al singleton.

        //layoutManager = (LinearLayoutManager(context as MainActivity)) as LinearLayoutManager
        initOnClickListener()
    }

    private fun setScrollWithOffsetLinearLayout() {
         layoutManager = ((context as MainActivity)
             .binding.myRecyclerView.layoutManager as LinearLayoutManager)
    }

    /*
    Método que asigna el listener al botón de añadir.
     */
    private fun initOnClickListener() {
        val myActivity = context as MainActivity
        myActivity.binding.btnAdd.setOnClickListener {
            addHotel()
        }

    }

    fun loggOut() {
        Toast.makeText(context, "He mostrado los datos en pantalla", Toast.LENGTH_LONG).show()
        listHotels.forEach{
            println (it)
        }
    }

    fun setAdapter() {
        val myActivity = context as MainActivity

        adapterHotel =  AdapterHotel(  //creo el adapter y me lo guardo en una propiedad
            listHotels,

            {
                    pos-> delHotel(pos) //eliminará el hotel seleccionado
            },

            {
                    pos-> updateHotel(pos) //actualizara el hotel seleccionado
            }
        )
        myActivity.binding.myRecyclerView.adapter = adapterHotel

    }


    /*
    Actualiza un hotel, dado el actualizado
     */
    fun updateHotel(pos: Int){
        //Aquí habrá que crear un diálogo con los datos del hotel para modificar.
       // Toast.makeText(context, "Actualizaremos el hotel de posición $pos", Toast.LENGTH_LONG).show()
        //Aquí, llamaremos al Dialog para editar.

        val editDialog = DialogEditHotel(listHotels.get(pos)){
            editHotel -> okOnEditHotel(editHotel, pos)
        }
        val myActivity = context as MainActivity
        editDialog.show(myActivity.supportFragmentManager, "Editamos un hotel")


    }




    /*
    Añade un nuevo hotel.
     */
    fun addHotel(){
        Toast.makeText(context, "Añadiremos un nuevo hotel", Toast.LENGTH_LONG).show()
        val dialog = DialogNewHotel(){
            hotel -> okOnNewHotel(hotel)
        }
        val myActivity = context as MainActivity
        dialog.show(myActivity.supportFragmentManager, "Añadimos un nuevo hotel")

    }



    /*
    Elimina un hotel, dado su posición.
     */
    fun delHotel(pos : Int){
        //Aquí habrá que crear un diáglogo para borrar el hotel
        val dialog = DialogDeleteHotel(
            pos,
            listHotels.get(pos).name
        ){
            position -> okOnDeleteHotel(position)
         }

        val myActivity = context as MainActivity
        dialog.show(myActivity.supportFragmentManager, "Borraremos el hotel de posición $pos")
    }


    private fun okOnDeleteHotel(pos: Int) {
        listHotels.removeAt(pos)
        adapterHotel.notifyItemRemoved(pos)  //Notificamos sólo a esa posición
        Toast.makeText(context, "Pueblo borrado", Toast.LENGTH_LONG).show()

    }

    private fun okOnNewHotel(hotel: Hotel) {
        listHotels.add(listHotels.size, hotel) //Insertamos en la última posición.
        adapterHotel.notifyItemInserted(listHotels.lastIndex) //notificamos.
        //((context as MainActivity).binding.myRecyclerView as LinearLayoutManager)
       //     .scrollToPositionWithOffset(listHotels.lastIndex, 20)
        layoutManager.scrollToPositionWithOffset(listHotels.lastIndex, 20)
    }

    private fun okOnEditHotel(editHotel: Hotel, pos: Int) {
        listHotels.removeAt(pos)
        adapterHotel.notifyItemRemoved(pos)  //Notificamos sólo a esa posición
        listHotels.add(pos, editHotel)
        adapterHotel.notifyItemInserted(pos)
        layoutManager.scrollToPositionWithOffset(pos, 20)

    }
}