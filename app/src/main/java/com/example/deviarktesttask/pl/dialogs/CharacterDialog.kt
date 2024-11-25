package com.example.deviarktesttask.pl.dialogs

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.deviarktesttask.pl.activities.LearnedSpellsActivity
import com.example.deviarktesttask.pl.activities.NewSpellsActivity
import com.example.deviarktesttask.R
import com.example.deviarktesttask.bll.local.implementations.CharacterService
import com.example.deviarktesttask.bll.local.implementations.CharactersSpellsService
import com.example.deviarktesttask.dal.Character
import com.example.deviarktesttask.dal.local.MyApp
import com.example.deviarktesttask.dal.local.repositories.CharacterRepository
import com.example.deviarktesttask.dal.local.repositories.CharactersSpellsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL
import java.util.ArrayList

@SuppressLint("SetTextI18n")
class CharacterDialog(context: Context, character: Character) {
    private val dialog = Dialog(context)
    init {
        dialog.setContentView(R.layout.character_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.spell_dialog_bg)

        val image: ImageView = dialog.findViewById(R.id.image)
        val name: TextView = dialog.findViewById(R.id.name)
        val alternateNames: TextView = dialog.findViewById(R.id.alternate_names)
        val species: TextView = dialog.findViewById(R.id.species)
        val gender: TextView = dialog.findViewById(R.id.gender)
        val house: TextView = dialog.findViewById(R.id.house)
        val dateOfBirth: TextView = dialog.findViewById(R.id.date_of_birth)
        val yearOfBirth: TextView = dialog.findViewById(R.id.year_of_birth)
        val wizard: TextView = dialog.findViewById(R.id.wizard)
        val ancestry: TextView = dialog.findViewById(R.id.ancestry)
        val eyeColour: TextView = dialog.findViewById(R.id.eye_colour)
        val hairColour: TextView = dialog.findViewById(R.id.hair_colour)
        val patronus: TextView = dialog.findViewById(R.id.patronus)
        val hogwartsStudent: TextView = dialog.findViewById(R.id.hogwartsStudent)
        val hogwartsStaff: TextView = dialog.findViewById(R.id.hogwartsStaff)
        val actor: TextView = dialog.findViewById(R.id.actor)
        val alternateActors: TextView = dialog.findViewById(R.id.alternate_actors)
        val alive: TextView = dialog.findViewById(R.id.alive)
        val btnGoTeachSpell: Button = dialog.findViewById(R.id.btn_go_teach_spell)
        val btnLearnedSpells: Button = dialog.findViewById(R.id.btn_learned_spells)

        if(character.image != "") {
            val imageUrl = URL(character.image)
            Glide.with(context)
                .load(imageUrl)
                .into(image)
        }else{
            image.setImageResource(R.drawable.person_icon)
        }

        name.text = character.name
        if(!character.alternate_names.isNullOrEmpty()) {
            val stringBuilder = StringBuilder()
            stringBuilder.append("Alternate names:\n")
            for(alterName in character.alternate_names){
                stringBuilder.append("${alterName}\n")
            }
            stringBuilder.removeSuffix("\n")
            alternateNames.text = stringBuilder.toString()
        } else {
            alternateNames.visibility = View.GONE
        }
        species.text = "Species: ${character.species}"
        gender.text = "Gender: ${character.gender}"
        house.text = "House: ${character.house}"
        dateOfBirth.text = "Date of birth: ${character.dateOfBirth}"
        yearOfBirth.text = "Year of birth: ${character.yearOfBirth.toString()}"
        wizard.text = if(character.wizard) "Wizard" else "Not wizard"
        ancestry.text = "Ancestry: ${character.ancestry}"
        eyeColour.text = "Eye colour: ${character.eyeColour}"
        hairColour.text = "Hair colour: ${character.hairColour}"
        patronus.text = "Patronus: ${character.patronus}"
        if(character.hogwartsStudent) {
            hogwartsStudent.text = "Hogwarts student"
        }
        else {
            hogwartsStudent.visibility = View.GONE
        }
        if(character.hogwartsStaff) {
            hogwartsStaff.text = "Hogwarts staff"
        }
        else {
            hogwartsStaff.visibility = View.GONE
        }
        actor.text = "Actor: ${character.actor}"
        if(!character.alternate_actors.isNullOrEmpty()) {
            val stringBuilder = StringBuilder()
            stringBuilder.append("Alternate actors:\n")
            for(alterActor in character.alternate_actors){
                stringBuilder.append("${alterActor}\n")
            }
            alternateActors.text = stringBuilder.toString()
        } else {
            alternateActors.visibility = View.GONE
        }
        alive.text = if(character.alive) "Alive" else "Dead"

        btnGoTeachSpell.setOnClickListener{
            GlobalScope.launch {

                CharacterService(CharacterRepository(MyApp.database.characterDao())).upsertCharacter(character)

                val unknownSpells =
                    CharactersSpellsService(CharactersSpellsRepository(MyApp.database.charactersSpellsDao())).getUnknownSpells(
                        character.id
                    )

                (context as? Activity)?.runOnUiThread {
                    val intent = Intent(context, NewSpellsActivity::class.java)
                    intent.putExtra("CHARACTER_ID", character.id)
                    intent.putExtra("NEW_SPELLS", ArrayList(unknownSpells))
                    val options = ActivityOptions.makeCustomAnimation(
                        context,
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                    )
                    context.startActivity(intent, options.toBundle())
                    dialog.hide()
                }
            }
        }
        btnLearnedSpells.setOnClickListener{
            GlobalScope.launch {
                val learnedSpells =
                    CharactersSpellsService(CharactersSpellsRepository(MyApp.database.charactersSpellsDao())).getLearnedSpells(
                        character.id
                    )

                (context as? Activity)?.runOnUiThread {
                    val intent = Intent(context, LearnedSpellsActivity::class.java)
                    intent.putExtra("LEARNED_SPELLS", ArrayList(learnedSpells))
                    val options = ActivityOptions.makeCustomAnimation(
                        context,
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                    )
                    context.startActivity(intent, options.toBundle())
                    dialog.dismiss()
                }
            }
        }
    }
    fun show(){
        dialog.show()
    }
}