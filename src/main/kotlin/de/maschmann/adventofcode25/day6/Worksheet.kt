package de.maschmann.adventofcode25.day6

class Worksheet {
    val problems = mutableMapOf<Int, Problem>()

    private val numberPattern = Regex("\\d+")
    private val operationPattern = Regex("[+\\-*/]")

    fun addLine(line: String) {
        line.split(' ')
            .filter { it.isNotBlank() }
            .map { it.trim() }
            .forEachIndexed { index, s ->
                val problem = problems.getOrPut(index) { Problem() }
                if (numberPattern.matches(s)) problem.numbers.add(s.toLong())
                else if (operationPattern.matches(s)) problem.operation = Operation.fromCharacter(s[0])
            }
    }

    fun addColumns(columns: List<String>) {
        val firstColumnPattern = Regex("\\s*\\d+\\s*[+\\-*/]")
        columns.filter { it.isNotBlank() }
            .forEach { column ->
                if (firstColumnPattern.matches(column)) {
                    val problem = Problem().apply {
                        operation = Operation.fromCharacter(column.last())
                    }
                    problem.numbers.add(column.dropLast(1).trim().toLong())
                    problems[problems.size] = problem
                } else {
                    problems[problems.keys.max()]!!.numbers.add(column.trim().toLong())
                }
            }
    }

    fun getSumOfAllProblems() = problems.values.sumOf { it.calculate() }

}