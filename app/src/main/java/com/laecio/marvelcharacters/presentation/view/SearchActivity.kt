package com.laecio.marvelcharacters.presentation.view

import android.content.Intent
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
                { hero ->
                  val intent = Intent(this, InfosHero::class.java )
                    val b = Bundle()
                    val comics = arrayListOf<String?>()

                    hero.data.results[0].comics?.items?.forEach{ comic ->
                        comics.add(comic?.name)

                    }
                    b.putString("name", hero.data.results[0].name)
                    b.putString("description", hero.data.results[0].description)
                    b.putStringArrayList("comics", comics)

                    intent.putExtras(b)
                    startActivity(intent)
                },
                {}
            )
        }
    }
}