package de.maschmann.adventofcode25.day1

enum class Direction(
    val abbrevation: String
) {
    LEFT("L"),
    RIGHT("R");

    companion object {
        fun fromAbbreviation(abb: String) = entries.first { it.abbrevation == abb }
    }

    override fun toString(): String {
        return abbrevation
    }

}