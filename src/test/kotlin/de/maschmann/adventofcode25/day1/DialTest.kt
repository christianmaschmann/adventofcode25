package de.maschmann.adventofcode25.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DialTest {

    @ParameterizedTest
    @CsvSource(
        "0,LEFT,30,0,70",
        "90,LEFT,226,2,64",
        "50,LEFT,68,1,82",
        "50,LEFT,50,1,0",
        "50,LEFT,150,2,0",
        "50,RIGHT,50,1,0",
        "0,LEFT,100,1,0",
        "0,LEFT,110,1,90",
        "1,LEFT,110,2,91",
        "0,RIGHT,100,1,0",
        "50,RIGHT,150,2,0",
    )
    fun should_move_correctly(
        givenPosition: Int,
        direction: Direction,
        degrees: Int,
        expCount: Int,
        expPosition: Int
    ) {
        val dial = Dial(givenPosition)

        val count = dial.move(Rotation(direction, degrees))

        assertThat(count).isEqualTo(expCount)
        assertThat(dial.position).isEqualTo(expPosition)
    }

}