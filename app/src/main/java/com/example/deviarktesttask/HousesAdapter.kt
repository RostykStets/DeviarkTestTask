package com.example.deviarktesttask

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deviarktesttask.bll.remote.CharactersAPI
import com.example.deviarktesttask.dal.Character
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.util.ArrayList

class HousesAdapter(private val houses: List<Pair<Int, String>>) :
    RecyclerView.Adapter<HousesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val houseImage: ImageView = itemView.findViewById(R.id.houseImage)
        val houseTitle: TextView = itemView.findViewById(R.id.houseTitle)
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
            onItemCLick(house.second, holder.itemView)
        }
    }

    override fun getItemCount(): Int {
        return houses.size
    }

    private fun onItemCLick(house: String, itemView: View){

        GlobalScope.launch {
            val characters = CharactersAPI().getCharactersByHouse(house.lowercase())
            (itemView.context as? Activity)?.runOnUiThread {
                val intent = Intent(itemView.context, CharactersActivity::class.java)
                val options = ActivityOptions.makeCustomAnimation(
                    itemView.context,
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
                intent.putExtra("Characters", ArrayList(characters))
                itemView.context.startActivity(intent, options.toBundle())
            }
        }
    }
}