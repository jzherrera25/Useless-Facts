package com.example.uselessfacts

import android.arch.lifecycle.ViewModel

class UselessFactViewModel : ViewModel() {

    val url : String = "muselessfact.appspot.com"
    val endPoint : String = "/random.json?language=en"

    var uselessFact: String
        get() {
            return this.getUselessFactFromApi()
        }
        private set(value) {
            this.uselessFact = value
        }

    private fun getUselessFactFromApi(): String {
        var uselessFact: String

        uselessFact = TODO()
        return uselessFact
    }
}