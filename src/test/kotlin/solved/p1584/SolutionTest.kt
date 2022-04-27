package solved.p1584

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        listOf(Pair(0, 0), Pair(2, 2), Pair(3, 10), Pair(5, 2), Pair(7, 0)) to 20,
        listOf(Pair(3, 12), Pair(-2, 5), Pair(-4, 1)) to 18
    ).map { (input, expected) ->
        dynamicTest("The minimal cost to connect points $input should be $expected") {
            assertEquals(expected,
                Solution.PrimAlgorithm()
                    .minCostConnectPoints(input.map { pair -> intArrayOf(pair.first, pair.second) }
                        .toTypedArray())
            )
        }
    }
}