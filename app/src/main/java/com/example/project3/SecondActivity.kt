package com.example.project3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var share: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        share = findViewById(R.id.button2)

        val  randomNumber = randomGenerate(6)
        textView3.text = randomNumber


        var userName = receiveName()


        share.setOnClickListener {
            shareResult(userName, randomNumber)
        }

    }

    fun randomGenerate(count: Int): String {

        var randomnmber = List(count){
            (1..42).random()
        }

        return randomnmber.joinToString(" ")
    }

    fun receiveName(): String{
        // receive extra from intent
        var bundle: Bundle? = intent.extras

        var username = bundle?.getString("userName").toString()

        return username
    }

    fun shareResult(username: String, generatedNums: String){
        // Implict intents
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username generates these Numbers")
        i.putExtra(Intent.EXTRA_TEXT, "The Lottery Numbers are: $generatedNums")
        startActivity(i)
    }
}