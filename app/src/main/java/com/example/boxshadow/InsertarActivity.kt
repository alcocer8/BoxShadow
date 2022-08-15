package com.example.boxshadow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.room.Room
import com.example.boxshadow.database.AppDatabase
import com.example.boxshadow.database.Articulo
import com.example.boxshadow.databinding.ActivityInsertarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class InsertarActivity : AppCompatActivity() {

    private lateinit var bind: ActivityInsertarBinding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityInsertarBinding.inflate(layoutInflater)
        setContentView(bind.root)


        db = Room.databaseBuilder(this, AppDatabase::class.java, "Articulos")
            .enableMultiInstanceInvalidation().build()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_insert, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_insertar_save -> {
                insertArticulo()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertArticulo() {
        val id = bind.etInsertarId.text.toString()
        val name = bind.etInsertarName.text.toString()
        val price = bind.etInsertarPrice.text.toString().toDouble()
        val quantity = bind.etInsertarQuantity.text.toString().toInt()
        val descrption = bind.etInsertarDescripction.text.toString()


        GlobalScope.launch {
            db.articuloDao().insertArticulo(Articulo(null,id, name, price, quantity, descrption))
        }

        limpiarInput()
        Toast.makeText(this, "Insertado", Toast.LENGTH_SHORT).show()
    }

    private fun limpiarInput(){
        bind.etInsertarId.text.clear()
        bind.etInsertarName.text.clear()
        bind.etInsertarPrice.text.clear()
        bind.etInsertarQuantity.text.clear()
        bind.etInsertarDescripction.text.clear()
    }

}