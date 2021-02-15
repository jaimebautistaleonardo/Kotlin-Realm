package com.example.crudrealm.realm

import android.app.Application
import com.example.crudrealm.realm.migraciones.Migraciones
import com.example.crudrealm.realm.schemas.Tiendas
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmModel

class Configuracion : Application() {

    override fun onCreate(){
        super.onCreate()

        Realm.init(this)
        Realm.getInstance(getConfiguracion())
    }

    fun getConfiguracion() : RealmConfiguration
    {
        return RealmConfiguration.Builder()
            .name(Constantes().DB_CRUDS)
            .schemaVersion(2)
            .migration(Migraciones())
            .build()

    }

    private fun <E: RealmModel> recuperarIdMaximo(realm: Realm, clase: Class<E>,campoId: String): Int
    {
        val id : Number? = realm.where(clase).max(campoId)

        val idRecuperado :Int
        if(id == null) idRecuperado = 1
        else idRecuperado = id.toInt() +1
        return idRecuperado
    }

    fun generarIdAutoIncrement(id: Int) : Int
    {
        val realm: Realm = Realm.getInstance(getConfiguracion())

        val idAutoIncrement : Int = when (id){
            Constantes().ID_SCHEMA_TIENDA -> recuperarIdMaximo(realm, Tiendas::class.java,"id")
            else -> -1
        }

        realm.close()
        return idAutoIncrement
    }

}