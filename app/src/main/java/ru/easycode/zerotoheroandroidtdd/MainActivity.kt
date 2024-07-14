package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val state = UiState.Base("0")
    private lateinit var decrementButton: Button
    private lateinit var textView: TextView
    private lateinit var incrementButton: Button
    private val count = Count.Base(2, 4, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decrementButton = findViewById(R.id.decrementButton)
        textView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    companion object {
        private const val KEY = "stateKey"
    }
}