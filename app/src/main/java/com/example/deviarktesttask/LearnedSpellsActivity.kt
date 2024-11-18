package com.example.deviarktesttask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deviarktesttask.dal.Spell
import com.example.deviarktesttask.databinding.ActivityLearnedSpellsBinding
import com.example.deviarktesttask.pl.adapters.NewSpellsAdapter
import com.example.deviarktesttask.pl.adapters.SpellsAdapter

class LearnedSpellsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLearnedSpellsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnedSpellsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val newSpells: List<Spell> = intent.getParcelableArrayListExtra("LEARNED_SPELLS") ?: emptyList()

        runOnUiThread{
            val adapter = SpellsAdapter(this, newSpells)
            val spellsRecyclerView =
                findViewById<RecyclerView>(R.id.spells_recyclerview)
            spellsRecyclerView.layoutManager =
                LinearLayoutManager(this )
            spellsRecyclerView.adapter = adapter
        }

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}