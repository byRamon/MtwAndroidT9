package com.example.androidt7registro.helper

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.util.*


class DataConverter {
    @TypeConverter
    fun toDate(timeStamp:Long?): Date?{
        return if(timeStamp !=null)Date(timeStamp) else null
    }
    @TypeConverter
    fun toDate(strFecha:String): Date{
        val array = strFecha?.split("/").toTypedArray()
        return Date(array[2].toInt(), array[1].toInt(), array[0].toInt())
    }
    @TypeConverter
    fun toTimeStamp(date:Date):Long? = date?.time
}