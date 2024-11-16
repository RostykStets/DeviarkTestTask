package com.example.deviarktesttask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HousesAdapter(private val houses: List<Pair<Int, String>>) :
    RecyclerView.Adapter<HousesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val houseImage = itemView.findViewById<ImageView>(R.id.houseImage)
        val houseTitle = itemView.findViewById<TextView>(R.id.houseTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.houses_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val house = houses[position]
        holder.houseImage.setImageResource(house.first)
        holder.houseTitle.text = house.second
        holder.itemView.setOnClickListener{
            onItemCLick(house)
        }
    }

    override fun getItemCount(): Int {
        return houses.size
    }

    private fun onItemCLick(house: Pair<Int, String>){

    }
}