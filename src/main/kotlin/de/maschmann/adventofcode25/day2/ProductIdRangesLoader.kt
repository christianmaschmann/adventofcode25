package de.maschmann.adventofcode25.day2

import java.nio.file.Files
import java.nio.file.Path

class ProductIdRangesLoader(
    val inputFileName: String
) {
    fun read(): List<ProductIdRange> {
        return javaClass.getResource(inputFileName)?.let {
            Path.of(it.toURI())
        }?.let { path -> Files.readString(path) }
            ?.split(',')
            ?.map { range -> ProductIdRange.parse(range) }
            ?: throw IllegalArgumentException("There are no product ID ranges loaded from $inputFileName")
    }
}