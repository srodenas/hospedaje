package com.santi.pmdm.virgen.hospedaje.dialogues

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.santi.pmdm.virgen.hospedaje.MainActivity
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.databinding.DialogNewHotelBinding
import com.santi.pmdm.virgen.hospedaje.models.Hotel

class DialogNewHotel (
    val onNewHotelDialog: (Hotel)-> Unit
): DialogFragment() {

    private lateinit var activity: MainActivity


    /*
    Diálogo que inflará una nueva vista para recoger los datos
    del nuevo hotel a insertar.
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as MainActivity


    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(activity)

            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            val viewDialogNewHotel = inflater.inflate(R.layout.dialog_new_hotel, null)
            builder.setView(viewDialogNewHotel)
                // Add action buttons
                .setPositiveButton("Añadir",
                    DialogInterface.OnClickListener { dialog, id ->
                        val newHotel = recoverDataLayout(viewDialogNewHotel) as Hotel
                        if (
                            newHotel.name.isNullOrEmpty() ||
                            newHotel.city.isNullOrEmpty() ||
                            newHotel.province.isNullOrEmpty() ||
                                newHotel.phone.isNullOrEmpty()
                        ){
                            Toast.makeText(activity, "Algún campo está vacío", Toast.LENGTH_LONG).show()
                            getDialog()?.cancel()
                        }else{
                            onNewHotelDialog(newHotel)
                        }
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")


    }

    private fun recoverDataLayout(view: View): Any {
        val binding = DialogNewHotelBinding.bind(view)
        return Hotel(
            binding.txtViewName.text.toString(),
            binding.txtViewCity.text.toString(),
            binding.txtViewProvence.text.toString(),
            binding.txtViewPhone.text.toString(),
            binding.txtViewUrlImage.text.toString()
        )
    }
}

