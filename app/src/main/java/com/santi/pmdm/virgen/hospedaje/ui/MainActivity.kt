package com.santi.pmdm.virgen.hospedaje.ui


import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.databinding.ActivityMainBinding
import com.santi.pmdm.virgen.hospedaje.ui.fragment.hospedaje.controler.ControllerDetailsHotel
import com.santi.pmdm.virgen.hospedaje.ui.fragment.hospedaje.controler.ControllerFragmentHotels


class MainActivity : AppCompatActivity(){
    lateinit var binding : ActivityMainBinding

    /*
    Un NavigationView, maneja el menú del Drawer y el header.
     */
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    lateinit var controllerFragmentHotels : ControllerFragmentHotels
    lateinit var controllerDetailsHotel: ControllerDetailsHotel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initFab()
        initProcessDrawer()
        createControllers()


    }

    private fun createControllers() {
        controllerFragmentHotels = ControllerFragmentHotels(this)
        controllerDetailsHotel = ControllerDetailsHotel(this)
    }

    /*
    Aquí está la modificación que haré
     */
    private fun initProcessDrawer() {

        /*
        Esta forma sería válida, si en vez de un container fuera un fragment

         val navController = findNavController(R.id.container_fragment)
         */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment //Nuestro NavHostFragment
        navController = navHostFragment.navController //Nuestro navController

        /*
        1.- Personalizamos nuestra barra de superior personalizada. La incorporamos.
        2.- Hay que asegurarnos, de que el style deba extender de un tema que incluya un ActionBar.
        Nosotros hemos utilizado Theme.MaterialComponents.DayNight.DarkActionBar
         */
        setSupportActionBar(binding.appBarMain.myToolbar)


        //Necesitamos nuestro componente principal del Drawer.
        val navView = binding.myNavView

        /*
        Con appBarConfiguration, nos aseguramos la CONFIGURACIÓN mediante un drawer y sus destinos.
        1.- Administra el botón de navegación. Consideramos primer nivel todos excepto el listado de hoteles. Por tanto, configura destinos.
        2.- Como tenemos un DrawerLayout, lo configuramos para que el icono cambie con el icono de la hamburguesa cuando esté en el home y con la
        flecha <- cuando esté en un nivel inferior.
        3.- Hacemos que se sincronice o funcione con el navigation drawer.
         */
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.settingsFragment, R.id.shareFragment, R.id.aboutFragment,
                R.id.shortsFragment, R.id.subscriptionsFragment, R.id.libraryFragment
            ),
            binding.myDrawer
        )


        /*
        1.- Aplica la configuración del appBarConfiguration, vinculándolo con la navegación a partir del navController.
        2.- !!!!!Sin esto, no veríamos el botón de navegación !!!!!!
         */
        setupActionBarWithNavController(navController, appBarConfiguration)


        /*
        Hacemos que el componente de navegación, funcione correctamente con cada uno de los elementos del Drawer.
        1.- Sin esto, no podrá navegar a ningún destino.
         */
        navView.setupWithNavController(navController)

        /*
        Hacemos que el componente de navegación, funcione correctamente con cada uno de los elementos del Bottom
        1.- Sin esto, no podrá navegar a ningún destino.
         */
        binding.appBarMain.appBarMain.myBottonNavigation.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }



    /*
    Con este método, hacemos que funcione correctamente el botón de navegación hacia arriba.
    1.- Esto hace que que responda a los eventos de navegación. Controlará la apertura de abrir
    la barra lateral del drawer y su cierre.
    2.- Sin esto, no se abre/cierra el Drawer.
     */
    override fun onSupportNavigateUp(): Boolean{

       // val navController = findNavController(R.id.container_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()    }


    private fun initFab(){
        binding.appBarMain.appBarMain.fab.setOnClickListener{
            Toast.makeText(this, "Pulso + ", Toast.LENGTH_LONG).show()
        }
    }

   /* fun navigateDetails(pos: Int){
       // Toast.makeText(this, "He pulsado los detalles de un item de posición $pos", Toast.LENGTH_LONG).show()
      //  val navController = findNavController(R.id.container_fragment)
      //  navController.navigate(R.id.action_hospedajeFragment_to_detailsHotelFragment)
        navController.navigate(R.id.action_hospedajeFragment_to_detailsHotelFragment)

    }

    */

}