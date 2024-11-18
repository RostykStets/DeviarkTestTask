package com.example.deviarktesttask

import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deviarktesttask.dal.Character
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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

        val url = "https://hp-api.onrender.com/api/characters/house/${house.lowercase()}"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                e.printStackTrace()
                // Handle failure, optionally update the UI with an error message
                itemView.post {
                    // Show some error in the UI if needed
                }
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                response.use {
                    if (!response.isSuccessful) {
                        // Handle error response
                        return
                    }

                    val body = response.body?.string()
                    val gson = Gson()
                    val typeToken = object : TypeToken<List<Character>>() {}.type
                    val charactersToPass: List<Character> = gson.fromJson(body, typeToken)

                    // Switch back to the main thread to start the activity
                    itemView.post {
                        val intent = Intent(itemView.context, CharactersActivity::class.java)
                        val options = ActivityOptions.makeCustomAnimation(
                            itemView.context,
                            R.anim.slide_in_right,
                            R.anim.slide_out_left
                        )
                        intent.putExtra("Characters", ArrayList(charactersToPass))
                        itemView.context.startActivity(intent, options.toBundle())
                    }
                }
            }
        })

    }
}