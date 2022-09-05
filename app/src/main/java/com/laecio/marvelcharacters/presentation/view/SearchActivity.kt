package com.laecio.marvelcharacters.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laecio.marvelcharacters.R
import com.laecio.marvelcharacters.data.HeroMarvelRepository
import com.laecio.marvelcharacters.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val repository = HeroMarvelRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar).apply {
            title = getString(R.string.app_name)
        }

        binding.searchBtn.setOnClickListener {
            val text = binding.searchBar.text.toString()

            repository.searchByName(text,
                {
                 binding.title.text =   it.data.results[0].name
                },
                {}
            )
        }
    }
}