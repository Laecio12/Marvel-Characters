package com.laecio.marvelcharacters.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laecio.marvelcharacters.R
import com.laecio.marvelcharacters.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar).apply {
            title = getString(R.string.app_name)
        }
    }
}