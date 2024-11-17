package com.example.deviarktesttask

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.deviarktesttask.dal.Character
import com.example.deviarktesttask.databinding.ActivityCharactersBinding

class CharactersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharactersBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val characters: List<Character> = intent.getParcelableArrayListExtra("Characters") ?: emptyList()
        runOnUiThread{
            if (characters.isEmpty()){
                binding.characters.text = "Fail"
            }else{
                binding.characters.text = "Characters: " + characters.size
            }
        }
    }
}