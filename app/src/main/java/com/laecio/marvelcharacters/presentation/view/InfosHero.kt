package com.laecio.marvelcharacters.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laecio.marvelcharacters.databinding.ActivityInfosHeroBinding

class InfosHero : AppCompatActivity() {
   private lateinit var binding: ActivityInfosHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityInfosHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  b = intent.extras

        val name = b?.getString("name") ?: ""
        val description = b?.getString("description") ?: ""

        binding.heroName.text = name
        binding.heroDescription.text = description
    }
}