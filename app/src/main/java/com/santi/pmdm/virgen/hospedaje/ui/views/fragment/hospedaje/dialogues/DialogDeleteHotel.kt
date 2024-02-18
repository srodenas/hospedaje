package com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje.dialogues

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.interfaces.InterfaceOnClickDialog

/*
Diálogo para el borrado de un hotel.
Necesito un listener que sea del tipo interfaz para delegar las funciones onClick.
No utilizaré funciones de orden superior.
 */
class DialogDeleteHotel(
                        val pos : Int,      //position of Hotel
                        val name: String,  //name of Hotel
                        val onDeleteHotelDialog : (Int) -> Unit
) : DialogFragment() {
   // private lateinit var listener :


    /*
    Método que se crea inmediantamente antes del start. Verifico que
    implemente
     */

    /*override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            listener = context as InterfaceOnClickDialog
        }catch (e: ClassCastException) {
            throw ClassCastException((context.toString() +
                    "El dialogo necesita implementar de InterfaceOnClickDialog"))
        }
    }
*/
    /*
    Metodo que crea el diálogo
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       // return super.onCreateDialog(savedInstanceState)
        return activity?.let {
            // Build the dialog and set up the button click handlers
            val builder = AlertDialog.Builder(it)

            builder.setMessage("¿Deseas borrar el alojamiento $name?")
                .setPositiveButton("Si",
                    DialogInterface.OnClickListener { dialog, id ->
                        // Send the positive button event back to the host activity
                       onDeleteHotelDialog(pos)
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                        // Send the negative button event back to the host activity
                        dialog.dismiss()
                    })

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}