package de.maschmann.adventofcode25.day3

class Bank(
    val batteries: List<Int>
) {

    fun getBiggestBatteries(digits: Int): Long {
        return getBiggestBatteries(batteries, ArrayList(), digits)
            .map { it.toString() }
            .reduce { acc, s -> acc + s }
            .toLong()
    }

    private fun getBiggestBatteries(batteryList: List<Int>, digitsCollected: MutableList<Int>, digits: Int): List<Int> {
        val digitsLeft = digits - digitsCollected.size

        val biggestBattery = batteryList.subList(0, batteryList.size-(digitsLeft-1)).max()
        digitsCollected.add(biggestBattery)
        if (digitsCollected.size == digits) {
            return digitsCollected
        }
        val rearPart = batteryList.subList(batteryList.indexOf(biggestBattery)+1, batteryList.size)
        return getBiggestBatteries(rearPart, digitsCollected, digits)
    }

    companion object {
        fun parse(line: String) = Bank(line.map { it.toString().toInt() })
    }

}