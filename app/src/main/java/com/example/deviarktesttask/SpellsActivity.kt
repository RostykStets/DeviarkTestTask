package com.example.deviarktesttask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deviarktesttask.bll.local.implementations.SpellService
import com.example.deviarktesttask.bll.remote.SpellAPI
import com.example.deviarktesttask.dal.local.MyApp
import com.example.deviarktesttask.dal.local.repositories.SpellRepository
import com.example.deviarktesttask.databinding.ActivitySpellsBinding
import com.example.deviarktesttask.pl.adapters.SpellsAdapter
import kotlinx.coroutines.launch


class SpellsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpellsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpellsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        lifecycleScope.launch {

            val spells = SpellAPI().getAllSpells()

            val spellService = SpellService(SpellRepository(MyApp.database.spellDao()))
            for(spell in spells){
                spellService.upsertSpell(spell)
            }
            runOnUiThread {
                val adapter = SpellsAdapter(this@SpellsActivity, spells)
                val spellsRecyclerView =
                    findViewById<RecyclerView>(R.id.spells_recyclerview)
                spellsRecyclerView.layoutManager =
                    LinearLayoutManager(this@SpellsActivity )
                spellsRecyclerView.adapter = adapter
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}