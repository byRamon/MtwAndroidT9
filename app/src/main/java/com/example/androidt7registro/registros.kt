package com.example.androidt7registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_registros.*

class registros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registros)


        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val lstRegistros = ArrayList<Registro>()

        lstRegistros.add(Registro("hola","mundo"))

        val adapter = Adapter(lstRegistros)
        recycler.adapter = adapter
    }
}
