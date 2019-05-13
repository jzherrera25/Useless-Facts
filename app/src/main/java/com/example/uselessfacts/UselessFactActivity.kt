package com.example.uselessfacts

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class UselessFactActivity : AppCompatActivity() {

    private lateinit var uselessFactTextView : TextView
    private lateinit var showUselessFactButton : Button
    private lateinit var uselessFactViewModel : UselessFactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useless_facts)

        this.uselessFactViewModel = ViewModelProviders.of(this).get(UselessFactViewModel::class.java)
        this.uselessFactTextView = findViewById(R.id.uselessFactTextView)
        this.showUselessFactButton  = findViewById(R.id.showUselessFactButton)

        // Register onClickerListener
        this.showUselessFactButton.setOnClickListener {
            // Grab random fact from api and set funFactTextView text to the random fact.
            this.showUselessFactButton.text = this.uselessFactViewModel.uselessFact
        }
    }
}
