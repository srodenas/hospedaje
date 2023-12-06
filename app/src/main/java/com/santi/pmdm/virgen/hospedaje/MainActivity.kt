package com.santi.pmdm.virgen.hospedaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santi.pmdm.virgen.hospedaje.controler.Controller
import com.santi.pmdm.virgen.hospedaje.databinding.ActivityMainBinding
import com.santi.pmdm.virgen.hospedaje.fragment.hospedaje.HospedajeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var fragmentHotel : HospedajeFragment
    /*
    ActionBarDrawerToggle, controla el estado del cajón abierto o cerrado
    del NavigationDrawer.
    1.- Cuando se abre, el icono de flecha arriba cambia automácitamente para que
    vuelva para atrás, siempre que el cajón está abierto. Ese icono se encuentra
    en el Toolbar.
    2.- Posee un listener, para detectar cuando se abre o cierra el cajón.
    3.- Necesitamos sincronizar con el estado del Drawer, para que el icono del
    Toolbar, refleje correctamente el estado del Drawer. Cuando el drawer se abre,
    cambia el icono del Toolbar con una flecha hacia atrás. Cuando el drawer se cierra,
    cambia el icono de la flecha por otro nuevo.
     */


    /*
    Un NavigationView, maneja el menú del Drawer y el header.
     */
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDrawer()
        initNavView()

    }



    private fun initDrawer() {
        toggle = ActionBarDrawerToggle(
            this,
            binding.myDrawer,
            R.string.open,
            R.string.close)

        /*
        añadimos el listener para que el Toolbar se entere (cuando se abre o cierra)
         */
        binding.myDrawer.addDrawerListener(toggle)

        /*
        sincronizamos toggle con respecto al drawer, para el botón de acción
        del Toolbar
         */

        toggle.syncState()

        /*
        Debemos de habilitamos el botón de navegación hacia atrás en la Toolbar de la actividad.
        Suele ser la flecha hacia la izquierda y permite que el usuario navegue hacia atrás
        en la pila de actividades. Activa la función onOptionsItemSelected() y podemos
        manejar la acción de retroceso según nuestras necesidades.
        Si no lo activamos, tendremos que arrastrar el cajón del navigation.
         */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  //IMPORTANTE ACTIVARLO.
    }

    private fun initNavView() {
        //La expresión lambda, retorna un booleao.
        binding.myNavView.setNavigationItemSelectedListener { menu->
            when (menu.itemId){
                R.id.first_item -> {
                    Toast.makeText(this, "Primer Item", Toast.LENGTH_LONG).show()
                }

                R.id.second_item ->{
                    Toast.makeText(this, "Segundo Item", Toast.LENGTH_LONG).show()
                }
                R.id.third_item -> {
                    Toast.makeText(this, "Primer Item", Toast.LENGTH_LONG).show()
                }
            }
            true
        }
    }

    //Controlamos la pulsación del botón de navegación del Toolbar.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            true
        return super.onOptionsItemSelected(item)
    }


}