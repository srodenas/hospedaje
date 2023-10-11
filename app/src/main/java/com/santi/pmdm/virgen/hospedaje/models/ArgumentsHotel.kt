package com.santi.pmdm.virgen.hospedaje.models


/*
Este objeto único (singleton), lo tenemos para recuperar los nombre de los argumentos
al pasarle datos desde el activity al dialog.
 */
object ArgumentsHotel {
    const val ARGUMENT_NAME = "name"
    const val ARGUMENT_CITY = "city"
    const val ARGUMENT_PROVINCE ="province"
    const val ARGUMENT_PHONE ="phone"
    const val ARGUMENT_IMAGE = "image"
}