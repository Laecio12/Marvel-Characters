package com.laecio.marvelcharacters.models

data class HeroResponse(
    val data: InfoHero
)

data class InfoHero(
    val results: List<Hero>
)
data class Hero(
    val name: String,
    val description: String,
    val thumbnail: ImageItem?,
    val comics: ComicList?
    )

data class ImageItem(
    val path: String?,
    val extension: String?,
)

data class ComicList(
    val items: List< ComicItem>
)

data class ComicItem(
    val name: String?
)