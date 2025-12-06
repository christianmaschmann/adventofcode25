package de.maschmann.adventofcode25.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CafeteriaTest {

    @Test
    fun `should pass example`() {
        // ACT
        val actualCount = Cafeteria("/day5/example.txt").countFreshIngredients()

        // ASSERT
        assertThat(actualCount).isEqualTo(3)
    }

    @Test
    fun `should pass example part 2`() {
        // ACT
        val actualCount = Cafeteria("/day5/example.txt").countFreshConsideredIngredient()

        // ASSERT
        assertThat(actualCount).isEqualTo(14)
    }

}