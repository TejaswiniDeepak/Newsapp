package com.example.newsapp

import com.google.gson.annotations.SerializedName

class NewsResponse {
    @SerializedName("author")
    var author:String?=null

    @SerializedName("title")
    var title:String?=null
    @SerializedName("description")
    var description:String?=null

}