package com.example.boxshadow.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.boxshadow.MainActivity
import com.example.boxshadow.database.Articulo
import com.example.boxshadow.databinding.ItemArticuloBinding

class ArticuloViewHolder(itemView: View) : ViewHolder(itemView) {

    val bind = ItemArticuloBinding.bind(itemView)

    val id = bind.tvItemId
    val uuid = bind.tvItemUuid
    val name = bind.tvItemName
    val price = bind.tvItemPrice
    val quantity = bind.tvItemQuantity

    fun render(articuloModel:Articulo){
        id.text = articuloModel.id.toString()
        uuid.text = articuloModel.uuid
        name.text = articuloModel.name
        price.text = articuloModel.price.toString()
        quantity.text = articuloModel.quantity.toString()


    }




}