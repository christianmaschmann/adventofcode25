package de.maschmann.adventofcode25.day4

import java.awt.Point

class Grid(
    val rows: MutableList<String>
) {

    fun countAccessablePaperRolls(limit: Int): Int {
        return getAccessablePaperRolls(limit).size
    }

    fun removeAllAccessablePaperRolls(limit: Int): Int {
        val accessableRolls = getAccessablePaperRolls(limit)
        var count = accessableRolls.count()
        accessableRolls.forEach { point -> rows[point.y] = removeRoll(rows[point.y], point.x) }
        if (count > 0) {
            count += removeAllAccessablePaperRolls(limit)
        }
        return count
    }

    private fun getAccessablePaperRolls(limit: Int): List<Point> {
        return (0..<rows.count()).flatMap { row ->
            (0..<rows[row].count()).map { column ->
                if (isAccessable(row, column, limit)) Point(column, row) else null
            }
        }.filterNotNull()
    }

    private fun removeRoll(row: String, column: Int): String {
        return row.take(column) + "x" + row.substring(column + 1)
    }

    private fun isAccessable(row: Int, column: Int, limit: Int) = countNeighborPaperRolls(row, column) < limit

    private fun isPaperRoll(row: Int, column: Int): Boolean {
        return try {
            rows[row][column] == '@'
        } catch (ex: IndexOutOfBoundsException) {
            false
        }
    }

    private fun countNeighborPaperRolls(row: Int, column: Int): Int {
        if (!isPaperRoll(row, column)) {
            return 99
        }
        return (row - 1..row + 1)
            .flatMap { r ->
                (column - 1..column + 1)
                    .map { c -> (row != r || column != c) && isPaperRoll(r, c) }
            }
            .count { it }
    }

}