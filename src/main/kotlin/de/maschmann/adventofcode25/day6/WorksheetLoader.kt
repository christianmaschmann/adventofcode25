package de.maschmann.adventofcode25.day6

import java.nio.file.Files
import java.nio.file.Path

class WorksheetLoader(
    val inputFileName: String
) {
    fun read(): Worksheet {
        return Worksheet().also { worksheet ->
            javaClass.getResource(inputFileName)?.let {
                Path.of(it.toURI())
            }.let { path -> Files.readAllLines(path) }
                .forEach { line -> worksheet.addLine(line) }
        }
    }

    fun readVertical(): Worksheet {
        val lines = javaClass.getResource(inputFileName)?.let {
            Path.of(it.toURI())
        }.let { path -> Files.readAllLines(path) }

        return Worksheet().also { worksheet ->
            worksheet.addColumns(buildColumns(lines))
        }
    }


    fun buildColumns(lines: List<String>): List<String> {
        val columns = mutableMapOf<Int, String>()
        lines.forEach { line ->
            line.forEachIndexed { index, s ->
                run {
                    val column = columns.getOrPut(index, { "" })
                    columns[index] = column + s
                }
            }
        }
        return columns.toList()
            .sortedBy { it.first }
            .map { it.second }

    }
}
