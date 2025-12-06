package de.maschmann.adventofcode25.day6

enum class Operation(
    val sign: Char
) {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    fun perform(a: Long, b: Long): Long {
        return when(sign) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            '/' -> a / b
            else -> error("Invalid operation $sign")
        }
    }
    companion object {
        fun fromCharacter(c: Char) = entries.find { it.sign == c } ?: error("Unknown operation character $c")
    }

}