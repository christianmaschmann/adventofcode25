package de.maschmann.adventofcode25.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrintingDepartmentTest {

    @Test
    fun `should pass example`() {
        // ACT
        val actualCount = PrintingDepartment("/day4/example.txt").countAccessablePaperRolls()

        // ASSERT
        assertThat(actualCount).isEqualTo(13)
    }

    @Test
    fun `should pass example phase 2`() {
        // ACT
        val actualCount = PrintingDepartment("/day4/example.txt").retrieveAllAccessablePaperRolls()

        // ASSERT
        assertThat(actualCount).isEqualTo(43)
    }

}