package com.example.uselessfacts

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UselessFactViewModel : ViewModel() {

    private val uselessFactApiService: UselessFactApiService = UselessFactApiService.create()

    lateinit var uselessFact : MutableLiveData<String>

    // GET Api for random usless fact
    fun doAction() {
        val factory = this.uselessFactApiService.getUselessFact()
        factory.enqueue(object : Callback<UselessFactResult> {
            override fun onFailure(call: Call<UselessFactResult>, t: Throwable) {
                Log.d("UselessFactViewModel", "Failed to get useless fact.")
            }

            override fun onResponse(call: Call<UselessFactResult>, response: Response<UselessFactResult>) {
                Log.d("UselessFactViewModel", "Received useless fact.")
                Log.d("UselessFactViewModel", response.body()!!.text)
                uselessFact.value = response.body()!!.text
            }
        })
    }
}
