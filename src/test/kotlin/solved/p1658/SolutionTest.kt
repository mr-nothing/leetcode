package solved.p1658

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        Pair(listOf(1,1,4,2,3), 5) to 2,
        Pair(listOf(5,6,7,8,9), 4) to -1,
        Pair(listOf(3,2,20,1,1,3), 10) to 5
    ).map { (input, expected) ->
        dynamicTest("The minimum number of step to sum up ${input.second} from both ends of ${input.first} array should be $expected") {
            assertEquals(expected, Solution().minOperations(input.first.toIntArray(), input.second))
        }
    }
}