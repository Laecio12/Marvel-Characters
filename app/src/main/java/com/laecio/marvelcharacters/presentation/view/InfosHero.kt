package com.laecio.marvelcharacters.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.laecio.marvelcharacters.R
import com.laecio.marvelcharacters.databinding.ActivityInfosHeroBinding

class InfosHero : AppCompatActivity() {
   private lateinit var binding: ActivityInfosHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityInfosHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            title = getString(R.string.app_name)
            setDisplayHomeAsUpEnabled(true)
        }

        binding.toolbar.apply {
            setNavigationOnClickListener { onBackPressed() }
        }

        val  b = intent.extras

        val name = b?.getString("name") ?: ""
        val description = b?.getString("description") ?: ""
        val comics = b?.getStringArrayList("comics") ?: arrayListOf<String>()

        binding.heroName.text = name
        binding.heroDescription.text = description

        val adapter = ComicAdapter(comics)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.comicList.layoutManager = layoutManager

        binding.comicList.adapter = adapter


    }
}