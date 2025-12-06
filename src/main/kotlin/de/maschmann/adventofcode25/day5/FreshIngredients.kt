package de.maschmann.adventofcode25.day5

class FreshIngredients(
    val startId: Long,
    val endId: Long
) {

    fun isFresh(ingredient: Ingredient) = ingredient.id in startId..endId

    fun intersects(other: FreshIngredients): Boolean {
        return other.startId <= endId && other.endId >= startId
    }

    fun merge(other: FreshIngredients): FreshIngredients {
        require (intersects(other))
        return FreshIngredients(minOf(startId, other.startId), maxOf(endId, other.endId))
    }

    companion object {
        val pattern = Regex("(\\d+)-(\\d+)")

        fun parse(txt: String): FreshIngredients {
            return pattern.find(txt)
                ?.let { matchResult ->
                    FreshIngredients(
                        matchResult.groups[1]!!.value.toLong(),
                        matchResult.groups[2]!!.value.toLong()
                    )
                } ?: throw IllegalArgumentException("Could not parse $txt")
        }
    }

}