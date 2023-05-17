package com.example.newsapp.Interfaces

import xml.constants.Constants.API_KEY
import com.example.newsapp.dataClasses.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL ="https://newsapi.org/"

interface NewsInterface{
    @GET("v2/top-headlines?apiKey=${API_KEY}")
    fun getHeadlines(@Query("country") County:String, @Query("page") page: Int) : Call<News>
//
}
object NewsService{
    val  newsInstance:NewsInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}