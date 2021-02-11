package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface newsService {
    @GET("v2/top-headlines?")
    fun getnews(@Query("country")country:String,@Query("APPID") app_id:String) :Call<Newsdata>
}