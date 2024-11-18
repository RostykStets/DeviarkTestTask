package com.example.deviarktesttask.pl.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deviarktesttask.R
import com.example.deviarktesttask.databinding.ActivityHousesBinding
import com.example.deviarktesttask.pl.dialogs.HousesAdapter

class HousesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHousesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHousesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val houses = listOf(
            Pair(R.drawable.gryffindor_logo, "Gryffindor"),
            Pair(R.drawable.slytherin_logo, "Slytherin"),
            Pair(R.drawable.hufflepuff_logo, "Hufflepuff"),
            Pair(R.drawable.ravenclaw_logo, "Ravenclaw")
            )
        val adapter = HousesAdapter(houses)
        val housesRecyclerView = findViewById<RecyclerView>(R.id.houses_recyclerview)
        housesRecyclerView.layoutManager = GridLayoutManager(this, 2)
        housesRecyclerView.adapter = adapter

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}