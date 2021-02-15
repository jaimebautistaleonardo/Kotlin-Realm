package com.example.crudrealm.realm.migraciones

import io.realm.DynamicRealm
import io.realm.RealmMigration
import io.realm.RealmObjectSchema
import io.realm.RealmSchema

class Migraciones : RealmMigration{
    override fun hashCode(): Int = 37
    override fun equals(other: Any?): Boolean= (other is Migraciones)

    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        val schemas : RealmSchema = realm.schema
        if(oldVersion < newVersion){
            val schemaTiendas : RealmObjectSchema? = schemas.get("Tiendas")
            if(schemaTiendas == null){
                schemas.create("Tiendas")
                    .addField("id",Int::class.java)
                    .addField("DeterminanteGSP",Int::class.java)
                    .addField("Sucursal",String::class.java)
                    .addField("Cadena",String::class.java)
                    .addField("Activo",Int::class.java)
                    .addField("Latitud",Double::class.java)
                    .addField("Longitud",Double::class.java)
            }
        }
    }

}