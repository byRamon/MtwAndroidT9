package com.example.androidt7registro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.content_item.view.*

class Adapter (var list:ArrayList<Registro>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        fun bindItem(data:Registro){
            itemView.tvNombre.text = data.nombre.toString()
            itemView.tvFecha.text = data.fechaRegistro.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }
}