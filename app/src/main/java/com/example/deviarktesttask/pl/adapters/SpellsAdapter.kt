package com.example.deviarktesttask.pl.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deviarktesttask.R
import com.example.deviarktesttask.pl.dialogs.SpellDialog
import com.example.deviarktesttask.dal.Spell

class SpellsAdapter(private val context: Context, private val spells: List<Spell>):
    RecyclerView.Adapter<SpellsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val spellName: TextView = itemView.findViewById(R.id.spell_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.spells_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spell = spells[position]
        holder.spellName.text = spell.name
        holder.spellName.setOnClickListener{
            onItemClick(spell)
        }
    }

    override fun getItemCount(): Int {
        return spells.size
    }

    private fun onItemClick(spell: Spell){
        val dialog = SpellDialog(context, spell)
        dialog.show()
    }
}