package com.example.boxshadow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.boxshadow.adapter.ArticuloAdapter
import com.example.boxshadow.database.AppDatabase
import com.example.boxshadow.database.Articulo
import com.example.boxshadow.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        GlobalScope.launch {
            db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "Articulos").build()
            initRecycler(db.articuloDao().getAllArticulos())
        }
    }

    private fun initRecycler(articulos: List<Articulo>) {
        bind.rv1.layoutManager = LinearLayoutManager(this)
        bind.rv1.adapter = ArticuloAdapter(articulos)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_main_insert -> startActivity(Intent(this,InsertarActivity::class.java))
            R.id.item_main_cart -> Toast.makeText(this,"Carrito", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}