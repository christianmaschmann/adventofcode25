package de.maschmann.adventofcode25.day6

class Problem {

    val numbers = mutableListOf<Long>()
    lateinit var operation: Operation

    fun calculate() = numbers.reduce { a, b -> operation.perform(a, b) }
}