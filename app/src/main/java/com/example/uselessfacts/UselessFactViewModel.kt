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

    var uselessFact : MutableLiveData<String> = MutableLiveData()

    // GET Api for random useless fact
    fun doAction() {
        val factory = this.uselessFactApiService.getUselessFact()
        factory.enqueue(object : Callback<UselessFactResult> {
            override fun onFailure(call: Call<UselessFactResult>, t: Throwable) {
                Log.d("UselessFactViewModel", "Failed to get useless fact.")
            }

            override fun onResponse(call: Call<UselessFactResult>, response: Response<UselessFactResult>) {
                this@UselessFactViewModel.uselessFact.value = response.body()!!.text
            }
        })
    }
}
