package com.santi.pmdm.virgen.hospedaje.objects_models

import com.santi.pmdm.virgen.hospedaje.models.Hotel

object Repository {
    val listHotels : List<Hotel> = listOf(
        Hotel(
            "Antiguo Palacio de Atienza", "Atienza", "Guadalajara",
            "975 45 54 45", "https://www.tuscasasrurales.com/imagenes/galeria/8619_g28/ico_8619.jpg"
        ),
        Hotel(
            "La Casa del Vaquero", "Abiada", "Cantabria",
            "978 65 56 65", "https://www.tuscasasrurales.com/imagenes/galeria/9472_g98/ico_9472.jpg"
        ),
        Hotel(
            "Hotel Peñalta", "Bogarra", "Albacete",
            "967 98 89 98", "https://www.tuscasasrurales.com/imagenes/galeria/9607_g1/ico_9607.jpg"
        ),
        Hotel(
            "Hotel Felipe II", "Ayna", "Albacete",
            "967 22 33 44", "https://www.tuscasasrurales.com/imagenes/galeria/19802_g1/ico_19802.jpg"
        ),
        Hotel (
            "Bodas de Camacho", "Munera", "Albacete",
            "967 88 99 88" , "https://www.tuscasasrurales.com/imagenes/galeria/13941_g/ico_13941.jpg"
                ),
        Hotel(
            "Venta Ticiano", "Yeste" , "Albacete",
            "967 77 66 55", "https://www.tuscasasrurales.com/imagenes/galeria/19712_g1/ico_19712.jpg"
        ),
        Hotel (
            "El refugio de Celia" , "Pedro Muñoz", "Ciudad Real",
            "953 00 00 00" , "https://www.tuscasasrurales.com/imagenes/galeria/19156_g/ico_19156.jpg"
                )
    )
}