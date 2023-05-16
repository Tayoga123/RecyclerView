package com.mtg.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListHeroAdapter
    lateinit var adapterGrid: ListHeroAdapterGrid
    lateinit var adapterCard: ListHeroAdapterCard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun init() {
        recyclerView = findViewById(R.id.recycler_view)

        var data = ArrayList<Hero>()
        data.addAll(HeroesData().listData)

        adapterGrid = ListHeroAdapterGrid(data)
        adapter = ListHeroAdapter(data)
        adapterCard = ListHeroAdapterCard(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        SetMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun SetMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                Toast.makeText(applicationContext, "List", Toast.LENGTH_SHORT).show()
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
            }
            R.id.action_grid -> {
                Toast.makeText(applicationContext, "Grid", Toast.LENGTH_SHORT).show()
                recyclerView.layoutManager = GridLayoutManager(this, 2)
                recyclerView.adapter = adapterGrid
            }
            R.id.action_cardview -> {
                Toast.makeText(applicationContext, "CardView", Toast.LENGTH_SHORT).show()
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapterCard
            }
        }
    }
}