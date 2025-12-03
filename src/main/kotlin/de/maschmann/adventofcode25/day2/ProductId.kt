package de.maschmann.adventofcode25.day2


class ProductId(
    val productId: String
) {

    fun isSilly(): Boolean {
        return (1..productId.length / 2)
            .any { check(productId.take(it)) }
    }

    fun check(substring: String): Boolean {
        return Regex("($substring){2,}")
            .find(productId)
            ?.let { it.value == productId } ?: false
    }


    fun isSillySimple(): Boolean {
        val firstHalf = productId.take(productId.length / 2)
        val secondHalf = productId.substring(productId.length / 2, productId.length)
        return firstHalf == secondHalf
    }

}
