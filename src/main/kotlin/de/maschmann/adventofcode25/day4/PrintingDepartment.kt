package de.maschmann.adventofcode25.day4

class PrintingDepartment(
    val inputFile: String
) {

    fun countAccessablePaperRolls(): Int {
        return GridLoader(inputFile).read().countAccessablePaperRolls(4)
    }

    fun retrieveAllAccessablePaperRolls(): Int {
        return GridLoader(inputFile).read().removeAllAccessablePaperRolls(4)
    }

}