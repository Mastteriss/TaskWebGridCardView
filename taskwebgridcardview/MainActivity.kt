package com.example.taskwebgridcardview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var gridViewGV:GridView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private var list = mutableListOf(
        GridViewModel(R.drawable.yandex,"Yandex", "https://www.yandex.ru"),
        GridViewModel(R.drawable.gismeteo, "Gismeteo", "https://www.gismeteo.ru"),
        GridViewModel(R.drawable.google, "Google", "https://www.google.ru/?hl=ru"),
        GridViewModel(R.drawable.gmail, "Gmail", "https://www.gmail.com/mail/help/intl/ru/about.html?de.")
    )
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        gridViewGV = findViewById(R.id.gridViewGV)
        val adapter = GridViewAdapter(list, this)
        gridViewGV.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}