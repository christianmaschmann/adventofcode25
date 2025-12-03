package de.maschmann.adventofcode25.day2

class GiftShop(
    val inputFile: String
) {

    fun sumSillyProductIds(): Long {
        return ProductIdRangesLoader(inputFile).read()
            .flatMap { it.getProductIds() }
            .filter { it.isSilly() }
            .sumOf { it.productId.toLong() }
    }

}