package de.maschmann.adventofcode25.day6

class TrashCompactor(
    val inputFile: String
) {

    fun countProblemResults(): Long {
        return WorksheetLoader(inputFile)
            .read()
            .getSumOfAllProblems()
    }

    fun countProblemResultsVertical(): Long {
        return WorksheetLoader(inputFile)
            .readVertical()
            .getSumOfAllProblems()
    }

}