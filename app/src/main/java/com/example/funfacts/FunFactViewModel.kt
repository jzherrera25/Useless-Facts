package com.example.funfacts

import android.arch.lifecycle.ViewModel

class FunFactViewModel : ViewModel() {

    val url : String = "muselessfact.appspot.com"
    val endPoint : String = "/random.json?language=en"

    var funFact: String
        get() {
            return this.getFunFactFromApi()
        }
        private set(value) {
            this.funFact = value
        }

    private fun getFunFactFromApi(): String {
        var funFact: String

        funFact = TODO()
        return funFact
    }
}