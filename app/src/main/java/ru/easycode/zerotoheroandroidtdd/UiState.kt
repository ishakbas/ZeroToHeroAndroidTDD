package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(textView: TextView, button: Button)
    data class Base(val text: String) : UiState {
        override fun apply(textView: TextView, button: Button) {
            TODO("Not yet implemented")
        }
    }

    data class Max(val text: String) : UiState {
        override fun apply(textView: TextView, button: Button) {
            TODO("Not yet implemented")
        }
    }
}
