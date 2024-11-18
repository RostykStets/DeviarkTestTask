package com.example.deviarktesttask.pl.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deviarktesttask.R
import com.example.deviarktesttask.dal.Character
import java.net.URL


class CharactersAdapter(private val characters: List<Character>): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        val characterName: TextView = itemView.findViewById(R.id.character_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characters_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.characterName.text = character.name

        if(character.image != "") {
            val imageUrl = URL(character.image)
            Glide.with(holder.itemView)
                .load(imageUrl)
                .into(holder.characterImage)
        }else{
            holder.characterImage.setImageResource(R.drawable.person_icon)
        }
    }
}