package com.santi.pmdm.virgen.hospedaje.data.hospedaje_users.mem.objects_models

import com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models.Hotel

/*
Objeto con la lista de todos los hoteles llamado repositorio.
Son los datos originales. Como no va a haber persistencia, los datos
se irán modificando e insertando en memoria.
 */
object RepositoryObjects {
    val listHotels : List<Hotel> = listOf(
        Hotel(
            "Antiguo Palacio de Atienza", "Atienza", "Guadalajara",
            "975 45 54 45", "https://www.tuscasasrurales.com/imagenes/galeria/8619_g28/ico_8619.jpg",
            "Las 4 estrellas del Hotel Los Llanos es su mejor carta de presentación. A tan sólo unos metros del Parque de Abelardo Sánchez, en pleno centro de Albacete, el hotel cuenta con las mejores comodidades para un viaje de negocios o una estancia en la ciudad. Sus salones cuentan con una cocina castellana, siendo el lugar donde se realizan reuniones de negocios o fiestas familiares. El hotel ha sido reformado en los últimos años, por lo que todas sus instalaciones y habitaciones están decoradas y " +
                    "terminadas con las últimas novedades. Además, dentro del recinto del hotel se puede disfrutar de conexión Wi-fi " +
                    "y la posibilidad de alquilar ordenadores portátiles para realizar diferentes trabajos en las salas de reuniones. " +
                    "Otro de los servicios más interesantes del hotel es la posibilidad de alquilar vehículos para el trabajo o para el " +
                    "ocio desde la misma recepción 24 horas. Todas las habitaciones están completamente equipadas con las últimas novedades " +
                    "tecnológicas, como un televisor con satélite, televisor y baño renovado y completo. En todas ellas se puede disfrutar de internet y " +
                    "servicio de habitaciones de gran profesionalidad."
        ),
        Hotel(
            "La Casa del Vaquero", "Abiada", "Cantabria",
            "978 65 56 65", "https://www.tuscasasrurales.com/imagenes/galeria/9472_g98/ico_9472.jpg",
            "Las 4 estrellas del Hotel Los Llanos es su mejor carta de presentación. A tan sólo unos metros del Parque de Abelardo Sánchez, en pleno centro de Albacete, el hotel cuenta con las mejores comodidades para un viaje de negocios o una estancia en la ciudad. Sus salones cuentan con una cocina castellana, siendo el lugar donde se realizan reuniones de negocios o fiestas familiares. El hotel ha sido reformado en los últimos años, por lo que todas sus instalaciones y habitaciones están decoradas y " +
                    "terminadas con las últimas novedades. Además, dentro del recinto del hotel se puede disfrutar de conexión Wi-fi " +
                    "y la posibilidad de alquilar ordenadores portátiles para realizar diferentes trabajos en las salas de reuniones. " +
                    "Otro de los servicios más interesantes del hotel es la posibilidad de alquilar vehículos para el trabajo o para el " +
                    "ocio desde la misma recepción 24 horas. Todas las habitaciones están completamente equipadas con las últimas novedades " +
                    "tecnológicas, como un televisor con satélite, televisor y baño renovado y completo. En todas ellas se puede disfrutar de internet y " +
                    "servicio de habitaciones de gran profesionalidad."
        ),
        Hotel(
            "Hotel Peñalta", "Bogarra", "Albacete",
            "967 98 89 98", "https://www.tuscasasrurales.com/imagenes/galeria/9607_g1/ico_9607.jpg",
            "Las 4 estrellas del Hotel Los Llanos es su mejor carta de presentación. A tan sólo unos metros del Parque de Abelardo Sánchez, en pleno centro de Albacete, el hotel cuenta con las mejores comodidades para un viaje de negocios o una estancia en la ciudad. Sus salones cuentan con una cocina castellana, siendo el lugar donde se realizan reuniones de negocios o fiestas familiares. El hotel ha sido reformado en los últimos años, por lo que todas sus instalaciones y habitaciones están decoradas y " +
                    "terminadas con las últimas novedades. Además, dentro del recinto del hotel se puede disfrutar de conexión Wi-fi " +
                    "y la posibilidad de alquilar ordenadores portátiles para realizar diferentes trabajos en las salas de reuniones. " +
                    "Otro de los servicios más interesantes del hotel es la posibilidad de alquilar vehículos para el trabajo o para el " +
                    "ocio desde la misma recepción 24 horas. Todas las habitaciones están completamente equipadas con las últimas novedades " +
                    "tecnológicas, como un televisor con satélite, televisor y baño renovado y completo. En todas ellas se puede disfrutar de internet y " +
                    "servicio de habitaciones de gran profesionalidad."
        ),
        Hotel(
            "Hotel Felipe II", "Ayna", "Albacete",
            "967 22 33 44", "https://www.tuscasasrurales.com/imagenes/galeria/19802_g1/ico_19802.jpg",
            "Las 4 estrellas del Hotel Los Llanos es su mejor carta de presentación. A tan sólo unos metros del Parque de Abelardo Sánchez, en pleno centro de Albacete, el hotel cuenta con las mejores comodidades para un viaje de negocios o una estancia en la ciudad. Sus salones cuentan con una cocina castellana, siendo el lugar donde se realizan reuniones de negocios o fiestas familiares. El hotel ha sido reformado en los últimos años, por lo que todas sus instalaciones y habitaciones están decoradas y " +
                    "terminadas con las últimas novedades. Además, dentro del recinto del hotel se puede disfrutar de conexión Wi-fi " +
                    "y la posibilidad de alquilar ordenadores portátiles para realizar diferentes trabajos en las salas de reuniones. " +
                    "Otro de los servicios más interesantes del hotel es la posibilidad de alquilar vehículos para el trabajo o para el " +
                    "ocio desde la misma recepción 24 horas. Todas las habitaciones están completamente equipadas con las últimas novedades " +
                    "tecnológicas, como un televisor con satélite, televisor y baño renovado y completo. En todas ellas se puede disfrutar de internet y " +
                    "servicio de habitaciones de gran profesionalidad."
        ),
        Hotel (
            "Bodas de Camacho", "Munera", "Albacete",
            "967 88 99 88" , "https://www.tuscasasrurales.com/imagenes/galeria/13941_g/ico_13941.jpg",
            "Las 4 estrellas del Hotel Los Llanos es su mejor carta de presentación. A tan sólo unos metros del Parque de Abelardo Sánchez, en pleno centro de Albacete, el hotel cuenta con las mejores comodidades para un viaje de negocios o una estancia en la ciudad. Sus salones cuentan con una cocina castellana, siendo el lugar donde se realizan reuniones de negocios o fiestas familiares. El hotel ha sido reformado en los últimos años, por lo que todas sus instalaciones y habitaciones están decoradas y " +
                    "terminadas con las últimas novedades. Además, dentro del recinto del hotel se puede disfrutar de conexión Wi-fi " +
                    "y la posibilidad de alquilar ordenadores portátiles para realizar diferentes trabajos en las salas de reuniones. " +
                    "Otro de los servicios más interesantes del hotel es la posibilidad de alquilar vehículos para el trabajo o para el " +
                    "ocio desde la misma recepción 24 horas. Todas las habitaciones están completamente equipadas con las últimas novedades " +
                    "tecnológicas, como un televisor con satélite, televisor y baño renovado y completo. En todas ellas se puede disfrutar de internet y " +
                    "servicio de habitaciones de gran profesionalidad."
                ),
        Hotel(
            "Venta Ticiano", "Yeste" , "Albacete",
            "967 77 66 55", "https://www.tuscasasrurales.com/imagenes/galeria/19712_g1/ico_19712.jpg",
            "Las 4 estrellas del Hotel Los Llanos es su mejor carta de presentación. A tan sólo unos metros del Parque de Abelardo Sánchez, en pleno centro de Albacete, el hotel cuenta con las mejores comodidades para un viaje de negocios o una estancia en la ciudad. Sus salones cuentan con una cocina castellana, siendo el lugar donde se realizan reuniones de negocios o fiestas familiares. El hotel ha sido reformado en los últimos años, por lo que todas sus instalaciones y habitaciones están decoradas y " +
                    "terminadas con las últimas novedades. Además, dentro del recinto del hotel se puede disfrutar de conexión Wi-fi " +
                    "y la posibilidad de alquilar ordenadores portátiles para realizar diferentes trabajos en las salas de reuniones. " +
                    "Otro de los servicios más interesantes del hotel es la posibilidad de alquilar vehículos para el trabajo o para el " +
                    "ocio desde la misma recepción 24 horas. Todas las habitaciones están completamente equipadas con las últimas novedades " +
                    "tecnológicas, como un televisor con satélite, televisor y baño renovado y completo. En todas ellas se puede disfrutar de internet y " +
                    "servicio de habitaciones de gran profesionalidad."
        ),
        Hotel (
            "El refugio de Celia" , "Pedro Muñoz", "Ciudad Real",
            "953 00 00 00" , "https://www.tuscasasrurales.com/imagenes/galeria/19156_g/ico_19156.jpg",
            "Las 4 estrellas del Hotel Los Llanos es su mejor carta de presentación. A tan sólo unos metros del Parque de Abelardo Sánchez, en pleno centro de Albacete, el hotel cuenta con las mejores comodidades para un viaje de negocios o una estancia en la ciudad. Sus salones cuentan con una cocina castellana, siendo el lugar donde se realizan reuniones de negocios o fiestas familiares. El hotel ha sido reformado en los últimos años, por lo que todas sus instalaciones y habitaciones están decoradas y " +
                    "terminadas con las últimas novedades. Además, dentro del recinto del hotel se puede disfrutar de conexión Wi-fi " +
                    "y la posibilidad de alquilar ordenadores portátiles para realizar diferentes trabajos en las salas de reuniones. " +
                    "Otro de los servicios más interesantes del hotel es la posibilidad de alquilar vehículos para el trabajo o para el " +
                    "ocio desde la misma recepción 24 horas. Todas las habitaciones están completamente equipadas con las últimas novedades " +
                    "tecnológicas, como un televisor con satélite, televisor y baño renovado y completo. En todas ellas se puede disfrutar de internet y " +
                    "servicio de habitaciones de gran profesionalidad."
                )
    )
}