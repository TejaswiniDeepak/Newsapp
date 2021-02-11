package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private lateinit var adapter:RecyclerAdapter

private lateinit var linearLayoutManager: LinearLayoutManager
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val recyclerview:RecyclerView=findViewById(R.id.recycler)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager=LinearLayoutManager(this)
    recyclerview.layoutManager= linearLayoutManager
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(newsService::class.java)
        val call = service.getnews(country, Appid)
        call.enqueue(object : Callback<Newsdata> {
            override fun onResponse(call: Call<Newsdata>?, response: Response<Newsdata>?) {
                Log.i("response","${response!!.code()}")
               if(response!!.code()==200)
               {
                   val news=response.body()
                   adapter= RecyclerAdapter(news)
                   recyclerview.adapter= adapter
               }

            }

            override fun onFailure(call: Call<Newsdata>?, t: Throwable?) {
             Toast.makeText(this@MainActivity,t!!.message,Toast.LENGTH_SHORT).show()
            }

        })


    }

    companion object{
        var BaseUrl="http://newsapi.org/"
        var Appid="cbd4c70d4cb74574b9adefeb3f188057"
        var country="in"

    }


}