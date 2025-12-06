package de.maschmann.adventofcode25.day5

import java.nio.file.Files
import java.nio.file.Path

class FreshIngredientsLoader(
    val inputFileName: String
) {
    fun read(): List<FreshIngredients> {
        return javaClass.getResource(inputFileName)?.let {
            Path.of(it.toURI())
        }.let { path -> Files.readAllLines(path) }
            .filter { line -> line.isNotBlank() && line.contains('-') }
            .map { FreshIngredients.parse(it) }
    }
}