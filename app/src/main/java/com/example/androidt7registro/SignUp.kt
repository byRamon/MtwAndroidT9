package com.example.androidt7registro

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.androidt7registro.DataBase.DatabaseRegistros
import com.example.androidt7registro.helper.DataConverter
import com.example.androidt7registro.helper.doAsync
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.content_item.*
import java.util.*

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        btn_fecha.setOnClickListener{
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{
                    view: DatePicker, mYear: Int, mMonth: Int, mDay: Int ->
                    Fecha.setText(""+ mDay + "/" + (mMonth+1) + "/" + mYear)
                }, year, month, day)
            dpd.show()
        }
        crear_cuenta.setOnClickListener {
            val registro = com.example.androidt7registro.DataBase.Registro(et_nombre.text.toString(), Date())
            doAsync{
                DatabaseRegistros.getInstance(this)!!.registroDao().insertRegistro(registro)
            }.execute()
            val intent = Intent(this@SignUp, registros::class.java)
            startActivity(intent)
        }
        btn_ir_inicioSesion.setOnClickListener{
            val intent = Intent(this@SignUp, Login::class.java)
            startActivity(intent)
        }
    }
}
