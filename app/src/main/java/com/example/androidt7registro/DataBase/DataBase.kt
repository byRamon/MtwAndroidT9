package com.example.androidt7registro.DataBase

import android.content.Context
import androidx.room.*
import androidx.room.Database
import androidx.room.Dao
import com.example.androidt7registro.helper.DataConverter
import java.util.*
import org.jetbrains.annotations.NotNull
import com.example.androidt7registro.registros

@Database(entities = arrayOf(Registro::class), version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class DatabaseRegistros : RoomDatabase() {
    abstract fun registroDao() : RegistroDAO
    companion object{
        private const val DATABASE_NAME = "database.db"
        @Volatile
        private var INSTANCE : DatabaseRegistros? = null

        fun getInstance(context: Context) : DatabaseRegistros?{
            INSTANCE ?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseRegistros::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}


@Entity(tableName = Registro.TABLE_NAME)
data class Registro(
    @ColumnInfo(name = "usuario") @NotNull var usuario: String,
    @ColumnInfo(name = "fechaRegistro") var fechaRegistro: Date
) {
    companion object {
        const val TABLE_NAME = "tblRegistro"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idUsuario")
    var userId: Int = 0
}

@Dao
interface RegistroDAO {
    @Query("select * from tblRegistro order by fechaRegistro")
    fun allRegistro() : List<Registro>
    @Insert
    fun insertRegistro(registro: Registro)
}