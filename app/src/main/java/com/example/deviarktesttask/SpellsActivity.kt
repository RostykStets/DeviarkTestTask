package com.example.deviarktesttask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deviarktesttask.dal.Spell
import com.example.deviarktesttask.databinding.ActivitySpellsBinding
import com.example.deviarktesttask.pl.adapters.SpellsAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class SpellsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpellsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpellsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val url = "https://hp-api.onrender.com/api/spells"

        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.stackTrace
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) {
                        TODO()
                    }
                    else{
                        val body = response.body?.string()
                        var spells = listOf<Spell>()
                        try {
                            val gson = Gson()
                            val typeToken = object : TypeToken<List<Spell>>() {}.type
                            spells = gson.fromJson<List<Spell>>(body, typeToken)

                        }catch (exception: Exception){
                            exception.stackTrace
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
            }
        })

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}