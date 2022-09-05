package com.laecio.marvelcharacters.data


import com.laecio.marvelcharacters.models.HeroResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {
    @GET("v1/public/characters")
    fun searchByName(
        @Query("name") name:String,
        @Query("apikey") apikey:String,
        @Query("ts") ts:String,
        @Query("hash") hash:String,
    ): Call<HeroResponse>
}