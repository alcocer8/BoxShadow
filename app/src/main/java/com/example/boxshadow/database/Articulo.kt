package com.example.boxshadow.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Articulo(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val uuid: String,
    val name: String,
    val price: Double,
    val quantity: Int,
    val description: String
)