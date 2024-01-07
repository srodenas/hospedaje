package com.santi.pmdm.virgen.hospedaje


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
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
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
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


class MainActivity : AppCompatActivity(){
    lateinit var binding : ActivityMainBinding




    /*
    Un NavigationView, maneja el menú del Drawer y el header.
     */
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initFab()

        initProcessDrawer()


    }

    /*
    Aquí está la modificación que haré
     */
    private fun initProcessDrawer() {

       // val navHostFragment = supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment //Nuestro NavHostFragment
       // val navController = navHostFragment.navController //Nuestro navController
        setSupportActionBar(binding.appBarMain.myToolbar)

        val navController = findNavController(R.id.container_fragment)
        val navView = binding.myNavView
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.settingsFragment, R.id.shareFragment, R.id.aboutFragment,
                     R.id.shortsFragment, R.id.subscriptionsFragment, R.id.libraryFragment),
            binding.myDrawer
        )
        setupActionBarWithNavController(navController, appBarConfiguration) //Configuro la barra de acciones con el NavController y appBarConfiguration
        navView.setupWithNavController(navController)


       // binding.myNavigationDrawer.setupWithNavController(navController) //Configuro la navegación para el Drawer con el navController.
        binding.appBarMain.myBottonNavigation.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean{

        val navController = findNavController(R.id.container_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()    }


    private fun initFab(){
        binding.appBarMain.fab.setOnClickListener{
            Toast.makeText(this, "Pulso + ", Toast.LENGTH_LONG).show()
        }
    }




}