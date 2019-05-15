package com.example.uselessfacts

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.widget.Button
import android.widget.TextView

class UselessFactActivity : AppCompatActivity() {

    private lateinit var uselessFactTextView : TextView
    private lateinit var showUselessFactButton : Button
    private lateinit var uselessFactViewModel : UselessFactViewModel
    private var uselessFactObserver = Observer<String> { newUselessFact ->
        if (this::uselessFactTextView.isInitialized) {
            this.uselessFactTextView.text = newUselessFact
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useless_facts)

        this.uselessFactViewModel = ViewModelProviders.of(this).get(UselessFactViewModel::class.java)
        this.uselessFactTextView = findViewById(R.id.uselessFactTextView)
        this.showUselessFactButton  = findViewById(R.id.showUselessFactButton)

        this.uselessFactViewModel.uselessFact.observe(this, this.uselessFactObserver)

        // Register onClickerListener
        this.showUselessFactButton.setOnClickListener {
            // Do action
            this.uselessFactViewModel.doAction()
        }
    }

    override fun onStop() {
        super.onStop()

        this.uselessFactViewModel.uselessFact.removeObserver(this.uselessFactObserver)
    }
}
