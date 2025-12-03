package de.maschmann.adventofcode25.day1

import java.nio.file.Files
import java.nio.file.Path

class RotationLoader(
    val inputFileName: String
) {
    fun read(): List<Rotation> {
        return javaClass.getResource(inputFileName)?.let {
            Path.of(it.toURI())
        }.let { path -> Files.readAllLines(path) }
            .filter { line -> line.isNotBlank() }
            .map { line -> Rotation.parse(line) }
    }
}