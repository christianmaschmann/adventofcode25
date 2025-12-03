package de.maschmann.adventofcode25.day3

import java.nio.file.Files
import java.nio.file.Path

class BankLoader(
    val inputFileName: String
) {
    fun read(): List<Bank> {
        return javaClass.getResource(inputFileName)?.let {
            Path.of(it.toURI())
        }.let { path -> Files.readAllLines(path) }
            .filter { line -> line.isNotBlank() }
            .map { line -> Bank.parse(line) }
    }
}