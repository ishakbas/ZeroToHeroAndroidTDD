package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): UiState
    fun initial(number: String): UiState
    fun decrement(number: String): UiState

    class Base(val step: Int, val max: Int, val min: Int) : Count {

        init {
            if (step <= 0)
                throw IllegalStateException("step should be positive, but was $step")
            if (max < 0)
                throw IllegalStateException("max should be positive, but was $max")
            if (max < step)
                throw IllegalStateException("max should be more than step")
            if (max < min)
                throw IllegalStateException("max should be more than min")
        }

        override fun initial(number: String): UiState {
            val digits = number.toInt()

            return when (digits) {
                min -> UiState.Min(number)
                max -> UiState.Max(number)
                else -> UiState.Base(number)
            }
        }

        override fun increment(number: String): UiState {
            val digits = number.toInt()
            val result = digits + step
            return initial(result.toString())
        }

        override fun decrement(number: String): UiState {
            val digits = number.toInt()
            val result = digits - step
            return initial(result.toString())
        }
    }
}