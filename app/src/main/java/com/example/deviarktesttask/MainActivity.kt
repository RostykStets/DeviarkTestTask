package com.example.deviarktesttask

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.deviarktesttask.bll.remote.CharactersAPI
import com.example.deviarktesttask.dal.local.AppDatabase
import com.example.deviarktesttask.dal.local.MyApp
import com.example.deviarktesttask.dal.local.models.CharacterLocal
import com.example.deviarktesttask.dal.local.repositories.CharacterRepository
import com.example.deviarktesttask.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnGetAllCharacters.setOnClickListener{
            lifecycleScope.launch {
                val characters = CharactersAPI().getAllCharacters()
                val intent = Intent(this@MainActivity, CharactersActivity::class.java)
                intent.putExtra("Characters", ArrayList(characters))
                val options = ActivityOptions.makeCustomAnimation(
                    this@MainActivity,
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
                startActivity(intent, options.toBundle())
            }
        }

        binding.btnGetSpells.setOnClickListener{
            val intent = Intent(this, SpellsActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
            startActivity(intent, options.toBundle())
        }

        binding.btnGetHouses.setOnClickListener{
            val intent = Intent(this, HousesActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
            startActivity(intent, options.toBundle())
        }

        binding.btnGetLocalCharacters.setOnClickListener{

            lifecycleScope.launch {
                val localCharacters: List<CharacterLocal> =
                    CharacterRepository(MyApp.database.characterDao()).getCharacters()
                Toast.makeText(
                    this@MainActivity,
                    "Local characters amount: ${localCharacters.size}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}