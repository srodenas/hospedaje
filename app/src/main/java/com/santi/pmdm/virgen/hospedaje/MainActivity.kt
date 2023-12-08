package com.santi.pmdm.virgen.hospedaje


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.santi.pmdm.virgen.hospedaje.databinding.ActivityMainBinding
import com.santi.pmdm.virgen.hospedaje.databinding.BottonLayoutBinding
import com.santi.pmdm.virgen.hospedaje.databinding.ContentPpalBinding
import com.santi.pmdm.virgen.hospedaje.fragment.about.AboutFragment
import com.santi.pmdm.virgen.hospedaje.fragment.home.HomeFragment
import com.santi.pmdm.virgen.hospedaje.fragment.hospedaje.HospedajeFragment
import com.santi.pmdm.virgen.hospedaje.fragment.library.LibraryFragment
import com.santi.pmdm.virgen.hospedaje.fragment.settings.SettingsFragment
import com.santi.pmdm.virgen.hospedaje.fragment.share.ShareFragment
import com.santi.pmdm.virgen.hospedaje.fragment.shorts.ShortsFragment
import com.santi.pmdm.virgen.hospedaje.fragment.subscriptions.SubscriptionsFragment


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var fragmentHotel : HospedajeFragment
    lateinit var fragmentManager: FragmentManager
    lateinit var bindingincludeContentLayout : ContentPpalBinding
    lateinit var bindingincludeBottonLayout : BottonLayoutBinding
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
        bindingincludeContentLayout = ContentPpalBinding.bind(binding.includedContentLayout.root)
        bindingincludeBottonLayout = BottonLayoutBinding.bind(binding.includedBottonLayout.root)
        setContentView(binding.root)

        initDrawer()
        initBotton()
       // initFab()
        createFragment()
        initFragmentManager(savedInstanceState)
        initNavView()


    }

    private fun createFragment() {
        fragmentManager = supportFragmentManager
        fragmentHotel = HospedajeFragment()
    }


    private fun initDrawer() {

        setSupportActionBar(binding.myToolbar) //cargamos nuestro toolbar personalizado
        toggle = ActionBarDrawerToggle(
            this,
            binding.myDrawer,
            binding.myToolbar,
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


    } //fin initDrawer



    private fun initBotton(){
        //de momento no quiero incluir ningun fondo por medio del botton. Dejaré que trabaje el Drawer
        bindingincludeBottonLayout.myBottonNavigationNav.setBackground(null)  //cambiar despues a backgroound = null
        bindingincludeBottonLayout.myBottonNavigationNav.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.nav_home -> {
                    replaceFragment(bindingincludeContentLayout
                        .containerFragment.id, HomeFragment())
                }
                R.id.shorts -> {
                    replaceFragment(bindingincludeContentLayout
                        .containerFragment.id, ShortsFragment())
                }
                R.id.subscriptions -> {
                    replaceFragment(bindingincludeContentLayout
                        .containerFragment.id, SubscriptionsFragment())
                }
                R.id.library -> {
                    replaceFragment(bindingincludeContentLayout
                        .containerFragment.id, LibraryFragment())
                }
            }//fin when
            true
        }


    }
    private fun initFragmentManager(savedInstanceState : Bundle?) {

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_fragment
                    , HomeFragment())
                .commit()
            binding.myNavView.setCheckedItem(R.id.nav_home)
        }

       // replaceFragment(HomeFragment());

    } //fin initFragment




    private fun initNavView() {
        //La expresión lambda, retorna un booleao.
        binding.myNavView.setNavigationItemSelectedListener { menu->
            when (menu.itemId){
                R.id.nav_home -> {
                    replaceFragment(bindingincludeContentLayout
                        .containerFragment.id, HomeFragment())
                }

                R.id.nav_settings ->{
                    replaceFragment(bindingincludeContentLayout
                        .containerFragment.id, SettingsFragment())

                }

                R.id.nav_share -> {
                    replaceFragment(bindingincludeContentLayout
                        .containerFragment.id, ShareFragment())
                }

                R.id.nav_about ->{
                    replaceFragment(bindingincludeContentLayout
                        .containerFragment.id, AboutFragment())


                }

                R.id.nav_list_hotel -> {
                    replaceFragment(bindingincludeContentLayout
                        .containerFragment.id, fragmentHotel)
                }

            }
            binding.myDrawer.closeDrawer(GravityCompat.START)
            true
        }
    }


    private fun initFab(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottomsheetlayout)
        val videoLayout = dialog.findViewById<LinearLayout>(R.id.layoutVideo)
        val shortsLayout = dialog.findViewById<LinearLayout>(R.id.layoutShorts)
        val liveLayout = dialog.findViewById<LinearLayout>(R.id.layoutLive)
        val cancelButton = dialog.findViewById<ImageView>(R.id.cancelButton)

        videoLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Upload a Video is clicked", Toast.LENGTH_SHORT).show()
        }

        shortsLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Create a short is Clicked", Toast.LENGTH_SHORT)
                .show()
        }

        liveLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Go live is Clicked", Toast.LENGTH_SHORT).show()
        }

        cancelButton.setOnClickListener { dialog.dismiss() }
        dialog.show()

        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }


    override fun onBackPressed() {
        if (binding.myDrawer.isDrawerOpen(GravityCompat.START)) {
            binding.myDrawer.closeDrawer(GravityCompat.START);
        }
        else {
            finish()
        }
    }

    private fun replaceFragment(container: Int, fragment: Fragment) {
        fragmentManager
            .beginTransaction()
            .replace(container, fragment)
            .commit()
    }

    //Controlamos la pulsación del botón de navegación del Toolbar.
   /* override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            true
        return super.onOptionsItemSelected(item)
    }
*/





}