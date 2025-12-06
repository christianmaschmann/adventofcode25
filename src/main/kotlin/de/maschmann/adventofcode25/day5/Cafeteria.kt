package de.maschmann.adventofcode25.day5

class Cafeteria(
    val inputFile: String
) {

    fun countFreshIngredients(): Int {
        val ingredients = IngredientsLoader(inputFile).read()
        val freshIngredients = FreshIngredientsLoader(inputFile).read()

        return ingredients.count { ingredient ->
            freshIngredients.any { freshIngredients -> freshIngredients.isFresh(ingredient) }
        }
    }

    fun countFreshConsideredIngredient(): Long {
        return mergeFreshIngredients(FreshIngredientsLoader(inputFile).read())
            .sumOf { (it.endId - it.startId) + 1 }
    }

    fun mergeFreshIngredients(list: List<FreshIngredients>): List<FreshIngredients> {
        val mergedFreshIngredients = ArrayList<FreshIngredients>()
        list.forEach { freshIngredients ->
            val intersections = mergedFreshIngredients.filter { it.intersects(freshIngredients) }.toMutableList()
            intersections.add(0, freshIngredients)
            val mergedIntersections = intersections.reduce { a, b -> a.merge(b) }
            mergedFreshIngredients.removeAll(intersections)
            mergedFreshIngredients.add(mergedIntersections)
        }
        return mergedFreshIngredients
    }
}