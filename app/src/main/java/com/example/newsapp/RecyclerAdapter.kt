package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val newsdata:Newsdata):RecyclerView.Adapter<RecyclerAdapter.NewsViewHolder>() {

    class NewsViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var author:TextView=v.findViewById(R.id.tv_author)
        var title:TextView=v.findViewById(R.id.tv_title)
        var decription:TextView=v.findViewById(R.id.tv_description)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
     val itemView=LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewlayout,parent,false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       val details=newsdata
        holder.author.text=details.author
        holder.title.text=details.title
        holder.decription.text=details.description
    }

    override fun getItemCount(): Int {
        return 1
    }


}