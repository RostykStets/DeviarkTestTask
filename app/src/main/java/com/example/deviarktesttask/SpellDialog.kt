package com.example.deviarktesttask

import android.app.Dialog
import android.content.Context
import android.widget.TextView
import com.example.deviarktesttask.dal.Spell

class SpellDialog
    (context: Context, spell: Spell) {
        private val dialog: Dialog = Dialog(context)
    init {
        dialog.setContentView(R.layout.spell_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.spell_dialog_bg)
        val name:TextView = dialog.findViewById(R.id.spell_name_dialog)
        val description:TextView = dialog.findViewById(R.id.spell_description_dialog)
        name.text = spell.name
        description.text = spell.description
    }
    fun show(){
        dialog.show()
    }
}