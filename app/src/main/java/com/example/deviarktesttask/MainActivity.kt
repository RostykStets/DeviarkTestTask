package com.example.deviarktesttask

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.deviarktesttask.dal.Character
import com.example.deviarktesttask.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnGetAllCharacters.setOnClickListener{
            lifecycleScope.launch {
                val characters = getAllCharacters()
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
    }

    private suspend fun getAllCharacters(): List<Character> {
        val url = "https://hp-api.onrender.com/api/characters"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        return withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val body = response.body?.string()
                val gson = Gson()
                val typeToken = object : TypeToken<List<Character>>() {}.type
                gson.fromJson(body, typeToken)
            } else {
                emptyList()
            }
        }
    }
}