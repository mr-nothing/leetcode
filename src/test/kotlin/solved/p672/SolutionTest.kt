package solved.p672

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test brute force solution`() = listOf(
        Pair(1, 1) to 2,
        Pair(2, 1) to 3,
        Pair(3, 1) to 4
    ).map { (input, expected) ->
        dynamicTest("There should be $expected variants of ${input.first} bulb states after ${input.second} button presses") {
            assertEquals(expected, Solution.BruteForceSolution().flipLights(input.first, input.second))
        }
    }

    @TestFactory
    fun `test smart solution`() = listOf(
        Pair(1, 1) to 2,
        Pair(2, 1) to 3,
        Pair(3, 1) to 4
    ).map { (input, expected) ->
        dynamicTest("There should be $expected variants of ${input.first} bulb states after ${input.second} button presses") {
            assertEquals(expected, Solution.GodHelpMeSolution().flipLights(input.first, input.second))
        }
    }
}