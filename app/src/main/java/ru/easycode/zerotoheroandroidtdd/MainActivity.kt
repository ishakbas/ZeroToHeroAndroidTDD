package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var state: UiState = UiState.Min("0")
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
        state.apply(textView, decrementButton, incrementButton)

        decrementButton.setOnClickListener {
            state = count.decrement(textView.text.toString())
            state.apply(textView, decrementButton, incrementButton)
        }
        incrementButton.setOnClickListener {
            state = count.increment(textView.text.toString())
            state.apply(textView, decrementButton, incrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(KEY) as UiState
        }
        state.apply(textView, decrementButton, incrementButton)
    }

    companion object {
        private const val KEY = "stateKey"
    }
}