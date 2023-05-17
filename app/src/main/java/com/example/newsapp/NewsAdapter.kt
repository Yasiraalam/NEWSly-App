package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.dataClasses.Article
import com.example.newsapp.databinding.ItemLayoutBinding



class NewsAdapter(private val context: Context, private val article:List<Article>): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val items = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(items)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val allItems = article[position]
       holder.bind(allItems)
//        holder.newsTitle.text = article.title
//        holder.newsDiscription.text = article.description
//        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return  article.size
    }
  class MyViewHolder(private val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
      fun bind(article: Article){
          binding.NewsTitle.text = article.title
          binding.NewsDiscription.text = article.description
          Glide.with(binding.root.context).load(article.urlToImage).into(binding.NewsImg)
      }
//      binding.newsTitle  =ItemView.NewsTitle
//      val newsDiscription =ItemView.NewsDiscription
//      val newsImage = ItemView.NewsImg

  }

}
