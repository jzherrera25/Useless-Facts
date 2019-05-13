package com.example.funfacts

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FunFactActivity : AppCompatActivity() {

    private lateinit var funFactTextView : TextView
    private lateinit var showFunFactButton : Button
    private lateinit var funFactViewModel : FunFactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun_facts)

        this.funFactViewModel = ViewModelProviders.of(this).get(FunFactViewModel::class.java)
        this.funFactTextView = findViewById(R.id.funFactTextView)
        this.showFunFactButton  = findViewById(R.id.showFunFactButton)

        // Register onClickerListener
        this.showFunFactButton.setOnClickListener {
            // Grab random fact from api and set funFactTextView text to the random fact.
            this.funFactTextView.text = this.funFactViewModel.funFact
        }
    }
}
