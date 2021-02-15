package com.example.crudrealm.realm.schemas

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.io.Serializable

@RealmClass
open class Tiendas :RealmObject(),Serializable
{
    @PrimaryKey
    var id              :Int = 0
    var DeterminanteGSP : Int = 0
    var Sucursal        : String? = null
    var Cadena          : String? = null
    var Activo          : Int = 0
    var Latitud         : Double = 0.0
    var Longitud        : Double = 0.0
}