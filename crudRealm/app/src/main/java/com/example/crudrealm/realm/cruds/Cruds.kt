package com.example.crudrealm.realm.cruds

import com.example.crudrealm.realm.Configuracion
import com.example.crudrealm.realm.Constantes
import com.example.crudrealm.realm.schemas.Tiendas
import io.realm.Realm

class Cruds {

    private val realm : Realm = Realm.getInstance(Configuracion().getConfiguracion())

    fun cerrar() = realm.close()

    fun add(tiendas: Tiendas): Int {
        val id : Int = Configuracion().generarIdAutoIncrement(Constantes().ID_SCHEMA_TIENDA)

        realm.beginTransaction()
        tiendas.id = id
        realm.insert(tiendas)
        realm.commitTransaction()

        return id
    }


}