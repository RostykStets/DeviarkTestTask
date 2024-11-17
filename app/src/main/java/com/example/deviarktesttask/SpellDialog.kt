package com.example.deviarktesttask

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.example.deviarktesttask.dal.Spell

class SpellDialog//dialog.window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    (context: Context, spell: Spell) {
        private var dialog: Dialog = Dialog(context)
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