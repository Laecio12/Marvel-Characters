package com.laecio.marvelcharacters.models

data class HeroResponse(
    val data: InfoHero
)

data class InfoHero(
    val results: List<Hero>
)
data class Hero(
    val name: String,
    val description: String
)
