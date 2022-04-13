package p59

/**
 * The code in each WHEN branch can be refactored into single function, but I decided to left it as is for better understanding.
 */
class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) { 0 } }
        val threshold = n * n

        // Start point [-1; 0] to enter matrix and fill first cell without additional conditions
        var h = -1
        var v = 0

        // Bounds of the matrix left that we still need to fill
        var hMin = 0
        var hMax = result.lastIndex
        var vMin = 0
        var vMax = result.lastIndex

        // Start with the RIGHT direction
        var direction = Direction.RIGHT
        for (element in 1..threshold) {
            when (direction) {
                Direction.RIGHT -> {
                    if (h == hMax) {
                        // If we reached the end of the matrix for the RIGHT direction
                        direction = Direction.DOWN // Start to move DOWN
                        vMin++ // Shrink bound for the UP direction
                        v++ // Make DOWN step
                    } else {
                        h++ // Make RIGHT step
                    }
                }
                Direction.DOWN -> {
                    if (v == vMax) {
                        // If we reached the end of the matrix for the DOWN direction
                        direction = Direction.LEFT // Start to move LEFT
                        hMax-- // Shrink bound for the RIGHT direction
                        h-- // Make LEFT step
                    } else {
                        v++ // Make DOWN step
                    }
                }
                Direction.LEFT -> {
                    if (h == hMin) {
                        // If we reached the end of the matrix for the LEFT direction
                        direction = Direction.UP // Start to move UP
                        vMax-- // Shrink bound for the DOWN direction
                        v-- // Make UP step
                    } else {
                        h-- // Make LEFT step
                    }
                }
                Direction.UP -> {
                    if (v == vMin) {
                        // If we reached the end of the matrix for the LEFT direction
                        direction = Direction.RIGHT // Start to move RIGHT
                        hMin++ // Shrink bound for the LEFT direction
                        h++ // Make RIGHT step
                    } else {
                        v-- // Make UP step
                    }
                }
            }

            result[v][h] = element
        }

        return result
    }

    enum class Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }
}