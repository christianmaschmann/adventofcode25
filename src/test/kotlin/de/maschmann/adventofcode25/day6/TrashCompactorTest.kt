package de.maschmann.adventofcode25.day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TrashCompactorTest {

    @Test
    fun `should pass example`() {
        // ACT
        val actualCount = TrashCompactor("/day6/example.txt").countProblemResults()

        // ASSERT
        assertThat(actualCount).isEqualTo(4277556)
    }

    @Test
    fun `should pass example part 2`() {
        // ACT
        val actualCount = TrashCompactor("/day6/example.txt").countProblemResultsVertical()

        // ASSERT
        assertThat(actualCount).isEqualTo(3263827)
    }

}