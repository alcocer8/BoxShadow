package com.example.boxshadow.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Articulo::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun articuloDao() : ArticuloDao
}