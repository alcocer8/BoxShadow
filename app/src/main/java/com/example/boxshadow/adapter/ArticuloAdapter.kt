package com.example.boxshadow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.boxshadow.R
import com.example.boxshadow.database.Articulo

class ArticuloAdapter(val articulos: List<Articulo>) : RecyclerView.Adapter<ArticuloViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticuloViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ArticuloViewHolder(layoutInflater.inflate(R.layout.item_articulo, parent, false))
    }

    override fun onBindViewHolder(holder: ArticuloViewHolder, position: Int) = holder.render(articulos[position])


    override fun getItemCount(): Int = articulos.size
}