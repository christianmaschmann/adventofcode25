package de.maschmann.adventofcode25.day3

class Lobby(
    val inputFile: String
) {

    fun getJoltSum() = BankLoader(inputFile)
        .read()
        .sumOf { it.getBiggestBatteries(12) }

}