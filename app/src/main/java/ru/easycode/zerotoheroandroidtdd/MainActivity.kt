package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count = Count.Base(2)

        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            val number = textView.text
            textView.text = count.increment(number.toString())
        }
    }
}