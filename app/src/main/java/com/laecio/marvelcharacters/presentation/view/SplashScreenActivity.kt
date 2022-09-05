package com.laecio.marvelcharacters.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.laecio.marvelcharacters.databinding.ActivitySplashScreenBinding


class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Espera 3 segundos antes de abrir a tela de busca
        Handler(Looper.getMainLooper()).postDelayed({
            openSearch()
        }, 3000)
    }

    private fun openSearch () {
        val intent = Intent(this@SplashScreenActivity, SearchActivity::class.java)
        startActivity(intent)
        finish()
    }
}