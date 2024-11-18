package com.example.deviarktesttask.pl.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import com.example.deviarktesttask.R
import com.example.deviarktesttask.bll.local.implementations.CharactersSpellsService
import com.example.deviarktesttask.dal.CharactersSpells
import com.example.deviarktesttask.dal.Spell
import com.example.deviarktesttask.dal.local.MyApp
import com.example.deviarktesttask.dal.local.repositories.CharactersSpellsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewSpellDialog
    (context: Context, spell: Spell, characterId: String) {
    private val dialog: Dialog = Dialog(context)
    init {
        dialog.setContentView(R.layout.new_spell_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.spell_dialog_bg)
        val name: TextView = dialog.findViewById(R.id.spell_name_dialog)
        val description: TextView = dialog.findViewById(R.id.spell_description_dialog)
        val btnLearnSpell: Button = dialog.findViewById(R.id.btn_learn_spell)
        name.text = spell.name
        description.text = spell.description

        btnLearnSpell.setOnClickListener{
            GlobalScope.launch {
                val newRecord = CharactersSpells(characterId, spell.id)
                CharactersSpellsService(CharactersSpellsRepository(MyApp.database.charactersSpellsDao())).upsert(
                    newRecord
                )
                (context as? Activity)?.runOnUiThread {
                    Toast.makeText(context, "You learned new spell!", Toast.LENGTH_SHORT).show()
                    dialog.hide()
                }
            }
        }
    }
    fun show(){
        dialog.show()
    }
}