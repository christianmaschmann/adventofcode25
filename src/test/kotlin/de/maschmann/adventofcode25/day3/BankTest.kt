package de.maschmann.adventofcode25.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BankTest {

    @ParameterizedTest
    @CsvSource(
        "987654321111111,98",
        "811111111111119,89",
        "234234234234278,78",
        "818181911112111,92",
    )
    fun `should return biggest battery pair`(givenBank: String, expectedPair: Long) {
        // ACT
        val actualPair = Bank.parse(givenBank).getBiggestBatteries(2)

        // ASSERT
        assertThat(actualPair).isEqualTo(expectedPair)
    }

    @ParameterizedTest
    @CsvSource(
        "987654321111111,987654321111",
        "811111111111119,811111111119",
        "234234234234278,434234234278",
        "818181911112111,888911112111",
    )
    fun `should return biggest battery twelve pack`(givenBank: String, expectedPack: Long) {
        // ACT
        val actualPack = Bank.parse(givenBank).getBiggestBatteries(12)

        // ASSERT
        assertThat(actualPack).isEqualTo(expectedPack)
    }


}