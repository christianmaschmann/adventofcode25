package de.maschmann.adventofcode25.day1

class Dial(
    var position: Int = 50
) {

    init {
        println("The dial starts by pointing at $position.")
    }

    fun move(rotation: Rotation): Int {
        var zeroCounter = 0

        (1..rotation.degrees).forEach { _ ->
            when (rotation.direction) {
                Direction.LEFT -> position--
                Direction.RIGHT -> position++
            }
            if(position == 100) {
                position = 0
            }
            if(position == -1) {
                position = 99
            }
            if (position == 0) {
                zeroCounter++
            }
        }

        if (zeroCounter == 0) {
            println("The dial is rotated $rotation to point at $position.")
        } else {
            println("The dial is rotated $rotation to point at $position; during this rotation, it points at 0 $zeroCounter times.")
        }

        return zeroCounter
    }

}