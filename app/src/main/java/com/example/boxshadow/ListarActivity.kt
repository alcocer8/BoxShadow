package com.example.boxshadow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.boxshadow.adapter.ArticuloAdapter
import com.example.boxshadow.database.AppDatabase
import com.example.boxshadow.databinding.ActivityListarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListarActivity : AppCompatActivity() {
    private lateinit var bind : ActivityListarBinding
    private lateinit var db : AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityListarBinding.inflate(layoutInflater)
        setContentView(bind.root)
        db = Room.databaseBuilder(this,AppDatabase::class.java, "Articulos")
            .enableMultiInstanceInvalidation()
            .build()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        val recycle = bind.rc1
        recycle.layoutManager = LinearLayoutManager(this)
        GlobalScope.launch {
            recycle.adapter = ArticuloAdapter(db.articuloDao().getAllArticulos())
        }
    }
}