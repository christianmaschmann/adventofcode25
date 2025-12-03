package de.maschmann.adventofcode25.day1

class SecretEntrance(
    val file: String
) {

    fun countZeroPositions(): Int {
        var counter = 0
        val dial = Dial()
        readInput()
            .forEach {
                counter += dial.move(it)
            }
        return counter
    }

    private fun readInput(): List<Rotation> {
        return RotationLoader(file).read()
    }
}