package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.dataClasses.News
import com.example.newsapp.Interfaces.NewsService
import com.example.newsapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
  private lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getNews()
    }

    private fun getNews() {

        val news = NewsService.newsInstance.getHeadlines("in",1)
        news.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                Log.d("Yasir", "fetching News here")
                val newsList = response.body()
                if(newsList!=null){
                    val adapter = NewsAdapter(this@MainActivity,newsList.articles)
                    binding.newsList.adapter= adapter
                    binding.newsList.layoutManager= LinearLayoutManager(this@MainActivity)
                }
//                other practice
//                adapter = response.body()?.articles?.let { NewsAdapter(this@MainActivity, it) }!!
//                binding.newsList.adapter= adapter
//                binding.newsList.layoutManager= LinearLayoutManager(this@MainActivity)

            }
            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d("Yasir", "error in fetching news",t)
            }
        })
    }
}