package com.laecio.marvelcharacters.data


import com.laecio.marvelcharacters.models.HeroResponse
import com.laecio.marvelcharacters.models.InfoHero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroMarvelRepository {
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun searchByName(name:String, success: (HeroResponse) -> Unit, error: () -> Unit){
        val api = retrofit.create(MarvelAPI::class.java)

        api.searchByName(name, KEY, TIMESTAMP, HASH).enqueue(
            object: Callback<HeroResponse>{
                override fun onResponse(call: Call<HeroResponse>?, response: Response<HeroResponse>?) {
                    if (response?.isSuccessful == true) {
                        success(response.body())
                    } else {
                        error()
                    }
                }

                override fun onFailure(call: Call<HeroResponse>?, t: Throwable?) {
                    error()
                }

            }
        )
    }

    companion object{
        val KEY = "e8cf78415e262b021a39d26dbee38c2a"
        val TIMESTAMP = "1662396526"
        val HASH = "28d5a2a294993bcfdf1aebfe9c5132a9"
    }
}