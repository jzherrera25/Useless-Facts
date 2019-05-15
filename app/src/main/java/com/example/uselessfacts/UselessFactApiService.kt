package com.example.uselessfacts

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface  UselessFactApiService {

    @GET("/random.json?language=en")
    fun getUselessFact() : Call<UselessFactResult>

    companion object Factory {
        fun create(): UselessFactApiService {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://randomuselessfact.appspot.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(UselessFactApiService::class.java)
        }
    }

}

