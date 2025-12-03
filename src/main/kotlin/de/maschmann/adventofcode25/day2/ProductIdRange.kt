package de.maschmann.adventofcode25.day2

class ProductIdRange(
    val start:Long,
    val end:Long) {

    fun getProductIds(): List<ProductId> = (start..end).map { ProductId(it.toString()) }

    companion object {
        fun parse(range: String): ProductIdRange {
            val strings = range.split('-')
            return ProductIdRange(strings[0].toLong(), strings[1].toLong())
        }
    }

}
