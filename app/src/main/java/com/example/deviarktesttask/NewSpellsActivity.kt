package com.example.deviarktesttask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deviarktesttask.dal.Spell
import com.example.deviarktesttask.databinding.ActivityNewSpellsBinding
import com.example.deviarktesttask.pl.adapters.NewSpellsAdapter

class NewSpellsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewSpellsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewSpellsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val newSpells: List<Spell> = intent.getParcelableArrayListExtra("NEW_SPELLS") ?: emptyList()
        val characterId: String = intent.getStringExtra("CHARACTER_ID")  ?: ""

        runOnUiThread{
            val adapter = NewSpellsAdapter(this@NewSpellsActivity, newSpells, characterId)
            val spellsRecyclerView =
                findViewById<RecyclerView>(R.id.spells_recyclerview)
            spellsRecyclerView.layoutManager =
                LinearLayoutManager(this@NewSpellsActivity )
            spellsRecyclerView.adapter = adapter
        }

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}