package com.example.deviarktesttask

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.deviarktesttask.dal.Character
import com.example.deviarktesttask.databinding.ActivityCharactersBinding
import com.example.deviarktesttask.pl.fragments.OtherWizardsFragment
import com.example.deviarktesttask.pl.fragments.StaffFragment
import com.example.deviarktesttask.pl.fragments.StudentsFragment
import com.google.android.material.tabs.TabLayout
import java.util.ArrayList

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

            var charactersToPass:List<Character>
            charactersToPass = characters.filter { character: Character ->  character.hogwartsStudent}
            val bundle = Bundle()
            bundle.putParcelableArrayList("CHARACTERS", ArrayList(charactersToPass))
            val studentsFragment = StudentsFragment()
            studentsFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.characters_frame, studentsFragment)
                .addToBackStack(null).commit()

            binding.charactersTablayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    var fragment = Fragment()
                    when(tab?.position){
                        0 -> {
                            fragment = StudentsFragment()
                            charactersToPass = characters.filter { character: Character ->  character.hogwartsStudent}
                        }
                        1 -> {
                            fragment = StaffFragment()
                            charactersToPass = characters.filter { character: Character ->  character.hogwartsStaff}
                        }
                        2 -> {
                            fragment = OtherWizardsFragment()
                            charactersToPass = characters.filter { character: Character ->  !character.hogwartsStudent && !character.hogwartsStaff}
                        }
                    }
                    bundle.putParcelableArrayList("CHARACTERS", ArrayList(charactersToPass))
                    fragment.arguments = bundle
                    supportFragmentManager.beginTransaction().replace(R.id.characters_frame, fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

            })
        }
    }
}