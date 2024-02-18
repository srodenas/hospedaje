package com.santi.pmdm.virgen.hospedaje.ui.views.fragment.hospedaje.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.santi.pmdm.virgen.hospedaje.ui.views.activities.MainActivity
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.databinding.DialogNewHotelBinding
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.ArgumentsHotel
import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel

class DialogEditHotel(
    val hotelToUpdate : Hotel,
    val nUpdateHotelDialog: (Hotel) -> Unit
)
    : DialogFragment() {

    lateinit var activity: MainActivity

    val ARGUMENT_NAME : String = ArgumentsHotel.ARGUMENT_NAME
    val ARGUMENT_CITY : String = ArgumentsHotel.ARGUMENT_CITY
    val ARGUMENT_PROVINCE :String = ArgumentsHotel.ARGUMENT_PROVINCE
    val ARGUMENT_PHONE : String = ArgumentsHotel.ARGUMENT_PHONE
    val ARGUMENT_IMAGE : String = ArgumentsHotel.ARGUMENT_IMAGE

    init {
        /*
        Prepararo el Bundle para pasárselo al Dialog.
         */
        val args = Bundle().apply {
            putString(ARGUMENT_NAME, hotelToUpdate.name)
            putString(ARGUMENT_CITY, hotelToUpdate.city)
            putString(ARGUMENT_PROVINCE, hotelToUpdate.province)
            putString(ARGUMENT_PHONE, hotelToUpdate.phone)
            putString(ARGUMENT_IMAGE, hotelToUpdate.image)
        }
        this.arguments = args

    }

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
            val viewDialogEditHotel = inflater.inflate(R.layout.dialog_new_hotel, null)
            setValuesIntoDialog(viewDialogEditHotel, this.arguments)

            builder.setView(viewDialogEditHotel)
                // Add action buttons
                .setPositiveButton("Aceptar",
                    DialogInterface.OnClickListener { dialog, id ->
                        val updateHotel = recoverDataLayout(viewDialogEditHotel) as Hotel
                        if (
                            updateHotel.name.isNullOrEmpty() ||
                            updateHotel.city.isNullOrEmpty() ||
                            updateHotel.province.isNullOrEmpty() ||
                            updateHotel.phone.isNullOrEmpty()
                        ){
                            Toast.makeText(activity, "Algún campo está vacío", Toast.LENGTH_LONG).show()
                            getDialog()?.cancel()
                        }else{
                            nUpdateHotelDialog(updateHotel)
                        }
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")



    }

    /*
    Seteamos los datos a mostrar en el Dialogo, para poder editarlos.
     */
    private fun setValuesIntoDialog(viewDialogEditHotel: View, arguments: Bundle?) {

            val binding = DialogNewHotelBinding.bind(viewDialogEditHotel)
            if (arguments != null) {
                binding.txtViewName.setText(arguments?.getString(ARGUMENT_NAME))
                binding.txtViewCity.setText(arguments?.getString(ARGUMENT_CITY))
                binding.txtViewProvence.setText(arguments?.getString(ARGUMENT_PROVINCE))
                binding.txtViewPhone.setText(arguments?.getString(ARGUMENT_PHONE))
                binding.txtViewUrlImage.setText(arguments?.getString(ARGUMENT_IMAGE))
            }

    }

    private fun recoverDataLayout(view: View): Any {

            val binding = DialogNewHotelBinding.bind(view)
            return Hotel(
                binding.txtViewName.text.toString(),
                binding.txtViewCity.text.toString(),
                binding.txtViewProvence.text.toString(),
                binding.txtViewPhone.text.toString(),
                binding.txtViewUrlImage.text.toString(),
                ""
            )
    }


}