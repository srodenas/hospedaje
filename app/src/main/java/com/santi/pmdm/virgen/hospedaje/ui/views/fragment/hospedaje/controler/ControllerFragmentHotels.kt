package com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje.controler

import android.content.Context

/*
Clase qye controlará todos los eventos que se produzcan.
1.- Al crearse, llama al Dao y le devuelve todos los Hoteles. Lo inicializa
 */
class ControllerFragmentHotels (val context : Context){
    //lateinit var listHotels : MutableList<Hotel>  //lista de objetos (Repositorio).
  /*  lateinit var adapterHotel: AdapterHotel     //Encargado de adaptar los objetos a las vistas.
    val getHotelsUseCase = GetHotelsUseCase()
    val newHotelUseCase = NewHotelUseCase()
    val getHotelForPosUseCase = GetHotelForPosUseCase()
    val deleteHotelUseCase = DeleteHotelUseCase()
    private lateinit var contextFragment: HospedajeFragment
    /*
    Layout que tiene el RecyclerView. Es un LinearLayout. Lo tenemos para controlar el offset
    del scroll. Cuando insertemos un nuevo hotel, quiero que se posicione en esa posición.
     */
    private lateinit var layoutManager  : LinearLayoutManager



    /*
    1.- Necesitamos el Layout del RecyclerView
    2.- Necesitamos cargar los datos del repositorio. Como es un singleton, se creará la primera vez.
    3.- Inicializamos el evento del botón añadir.
     */
    fun initData(){
       // listHotels = DaoHotels.dataService.toMutableList()
        setScrollWithOffsetLinearLayout()  //Necesitamos el LayoutManager para posicionar el offset del scroll
        //Aquí debería de crear listHotels como singleton
        //listHotels = DaoHotels.myDao.getDataHotels().toMutableList()  //llamamos al singleton.
        //listHotels = getHotelsUseCase()  //invocamos al caso de uso que nos devuelva todos los hoteles.
        setAdapter(getHotelsUseCase()) //invocamos al caso de uso que devolverá la lista de hoteles como singleton.
        initOnClickListener()
    }

    fun setContextFragment(context: HospedajeFragment){
        contextFragment = context
    }

    /*
    Cargamos el adaptador.
     */
    fun setAdapter(hotels : MutableList<Hotel>) {
        adapterHotel =  AdapterHotel(  //creo el adapter y me lo guardo en una propiedad
            hotels,

            {
                    pos-> delHotel(pos) //eliminará el hotel seleccionado
            },

            {
                    pos-> updateHotel(pos) //actualizara el hotel seleccionado
            },
            {
                    pos -> details(pos)  //para los detalles del item
            }
        )
        contextFragment
            .bindigFragment
            .myRecyclerView.adapter = adapterHotel

    }


    /*
       Necesitamos el gestor del Layout que tiene el RecyclerView. Lo casteamos a LinearLayout, porque
       cargamos como gestor de layout, un LinearLayout.
    */

    private fun setScrollWithOffsetLinearLayout() {
         layoutManager = contextFragment
             .bindigFragment
             .myRecyclerView
             .layoutManager as LinearLayoutManager
    }



    /*
    Método que asigna el listener al botón de añadir.
    1.- Al pulsar el botón de añadir, inicia el proceso del diálogo para añadir
    un nuevo alojamiento.
     */
    private fun initOnClickListener() {
        contextFragment
            .bindigFragment
            .btnAdd
            .setOnClickListener {
            addHotel()  //lambda que trata el evento del botón añadir. Inicia el Dialogo
        }

    }





    /*
    Actualiza un hotel, dado el actualizado
     */
    fun updateHotel(pos: Int){
        //Aquí habrá que crear un diálogo con los datos del hotel para modificar.
       // Toast.makeText(context, "Actualizaremos el hotel de posición $pos", Toast.LENGTH_LONG).show()
        //Aquí, llamaremos al Dialog para editar.
        getHotelForPosUseCase.setPos(pos)
        val editDialog = DialogEditHotel(getHotelForPosUseCase()){
            editHotel -> okOnEditHotel(editHotel, pos)
        }
        val myActivity = context as MainActivity
        editDialog.show(myActivity.supportFragmentManager, "Editamos un hotel")


    }

    /*
    Añade un nuevo hotel. Los datos debemos de capturarlo desde el Dialogo.
    La clase DialogNewHotel, recibe como parámetro una función lambda
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
        getHotelForPosUseCase.setPos(pos)
        val dialog = DialogDeleteHotel(
            pos,
           // listHotels.get(pos).name
            getHotelForPosUseCase().name
        ){
            position -> okOnDeleteHotel(position)
         }

        val myActivity = context as MainActivity
        dialog.show(myActivity.supportFragmentManager, "Borraremos el hotel de posición $pos")
    }


    fun details(pos : Int){
        Toast.makeText(context as MainActivity, "He pulsado los detalles de un item de posición $pos", Toast.LENGTH_LONG).show()

        val navController = contextFragment.findNavController()
        navController.navigate(HospedajeFragmentDirections.actionHospedajeFragmentToDetailsHotelFragment2(num = pos))

    }


    private fun okOnDeleteHotel(pos: Int) {
        deleteHotelUseCase.setPos(pos)
        deleteHotelUseCase()  //eliminamos el hotel
        //listHotels.removeAt(pos)
        adapterHotel.notifyItemRemoved(pos)  //Notificamos sólo a esa posición
      //  Toast.makeText(context, "Pueblo borrado", Toast.LENGTH_LONG).show()

    }

    private fun okOnNewHotel(hotel: Hotel) {
        newHotelUseCase.setHotel(hotel) //primero lo seteamos a su atributo.

      //  listHotels.add(listHotels.size, hotel) //Insertamos en la última posición.
        var pos  = newHotelUseCase()
        if ( pos != -1){
            /*
            Lo que hacemos es al insertar un nuevo hotel, de la última posición del scroll (ultimo pueblo)
            hacemos un desplazamiento de 20 para que veamos el nuevo pueblo.
             */
            adapterHotel.notifyItemInserted(pos) //notificamos.
            layoutManager.scrollToPositionWithOffset(pos, 20)
        }

    }



    private fun okOnEditHotel(editHotel: Hotel, pos: Int) {
       // listHotels.removeAt(pos)
      //  adapterHotel.notifyItemRemoved(pos)  //Notificamos sólo a esa posición
        okOnDeleteHotel(pos)
        okOnNewHotel(editHotel)
        /*listHotels.add(pos, editHotel)
        adapterHotel.notifyItemInserted(pos)
        layoutManager.scrollToPositionWithOffset(pos, 20)*/

    }


    fun loggOut() {
        Toast.makeText(context, "He mostrado los datos en pantalla", Toast.LENGTH_LONG).show()
        ListHotel.hotels.hospedajes.forEach{
            println (it)
        }
    }
*/
}