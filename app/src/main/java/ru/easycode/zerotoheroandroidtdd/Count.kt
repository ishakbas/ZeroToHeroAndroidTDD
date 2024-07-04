package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): String

    class Base(private val step: Int) : Count {

        private val sumStep =
            if (step > 0) step
            else throw IllegalStateException("step should be positive, but was $step")

        var result = 0
            private set

        override fun increment(number: String): String {
            val startNum = number.toInt()
            result = startNum + sumStep
            return result.toString()
        }
    }
}