package com.example.boxshadow.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticuloDao {

    @Query("SELECT * FROM Articulo")
    fun getAllArticulos(): List<Articulo>

    @Insert
    fun insertArticulo(articulo: Articulo)

}