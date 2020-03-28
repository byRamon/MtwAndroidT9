package com.example.androidt7registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidt7registro.DataBase.DatabaseRegistros
import com.example.androidt7registro.helper.DataConverter
import com.example.androidt7registro.helper.doAsync
import kotlinx.android.synthetic.main.activity_registros.*
import java.util.*
import kotlin.collections.ArrayList

class registros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registros)
        val lstRegistros = ArrayList<Registro>()
        doAsync{
            val registros = DatabaseRegistros.getInstance(this@registros)?.registroDao()?.allRegistro()
            runOnUiThread{
                registros?.forEach {
                    lstRegistros.add(Registro(it.usuario, it.fechaRegistro.toString()))
                }
                recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                val adapter = Adapter(lstRegistros)
                recycler.adapter = adapter
            }
        }.execute()

    }
}
