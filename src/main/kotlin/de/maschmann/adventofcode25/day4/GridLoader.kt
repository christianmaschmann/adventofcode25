package de.maschmann.adventofcode25.day4

import java.nio.file.Files
import java.nio.file.Path

class GridLoader(
    val inputFileName: String
) {
    fun read(): Grid {
        return javaClass.getResource(inputFileName)?.let {
            Path.of(it.toURI())
        }.let { path -> Files.readAllLines(path) }
            .filter { line -> line.isNotBlank() }
            .let { Grid(it.toMutableList()) }
    }
}