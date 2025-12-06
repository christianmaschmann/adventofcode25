package de.maschmann.adventofcode25.day5

import java.nio.file.Files
import java.nio.file.Path

class IngredientsLoader(
    val inputFileName: String
) {
    fun read(): List<Ingredient> {
        return javaClass.getResource(inputFileName)?.let {
            Path.of(it.toURI())
        }.let { path -> Files.readAllLines(path) }
            .filter { line -> line.isNotBlank() && !line.contains('-') }
            .map { Ingredient(it.toLong()) }
    }
}