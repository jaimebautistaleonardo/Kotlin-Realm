package com.example.crudrealm.actividad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crudrealm.R
import com.example.crudrealm.realm.cruds.Cruds
import com.example.crudrealm.realm.schemas.Tiendas

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val cruds : Cruds = Cruds()
        var tiendas : Tiendas = Tiendas()
        tiendas.Activo= 1
        tiendas.Cadena= "WALDOS"
        tiendas.DeterminanteGSP= 1
        tiendas.Latitud= 19.6299288
        tiendas.Longitud= -99.1236551
        tiendas.Sucursal= "Waldos Henry Ford"

        for (i in 1..5000) cruds.add(tiendas).toString()

    }
}