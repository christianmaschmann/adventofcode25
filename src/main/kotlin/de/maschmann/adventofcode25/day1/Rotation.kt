package de.maschmann.adventofcode25.day1

class Rotation(
    val direction: Direction,
    val degrees: Int,
) {
    companion object {
        fun parse(txt: String): Rotation {
            return Regex("([RL])(\\d+)").find(txt)?.let {
                Rotation(
                    Direction.fromAbbreviation(it.groupValues[1]),
                    it.groupValues[2].toInt()
                )
            } ?: throw IllegalArgumentException("Invalid rotation: $txt")
        }
    }

    override fun toString(): String {
        return "$direction$degrees"
    }

}

