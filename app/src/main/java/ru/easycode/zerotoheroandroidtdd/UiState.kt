package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(textView: TextView, button: Button) = Unit

    abstract class AbstractUiState(private val text: String) : UiState {
        override fun apply(textView: TextView, button: Button) {
            textView.text = text
        }
    }

    data class Base(private val text: String) : AbstractUiState(text)

    data class Max(private val text: String) : AbstractUiState(text) {
        override fun apply(textView: TextView, button: Button) {
            TODO("Not yet implemented")
        }
    }

    data class Min(private val text: String) : AbstractUiState(text) {
        override fun apply(textView: TextView, button: Button) {
            TODO("Not yet implemented")
        }
    }

}