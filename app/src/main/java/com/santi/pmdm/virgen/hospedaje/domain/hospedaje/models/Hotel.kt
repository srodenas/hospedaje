package com.santi.pmdm.virgen.hospedaje.domain.hospedaje.models

data class Hotel (
    var name: String,
    var city: String,
    var province: String,
    var phone: String,
    var image: String,
    var description: String
) {

    override fun toString(): String {
        return "Hotel(name='$name', city='$city', province='$province', phone='$phone', image='$image', description='$description')"
    }
}
