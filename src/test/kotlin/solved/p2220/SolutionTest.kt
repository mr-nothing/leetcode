package solved.p2220

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        InputData(13, 7) to 2,
        InputData(21, 29) to 1
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("To reach ${inputData.goal} from ${inputData.start} we need to do $expected bit flips") {
            Assertions.assertEquals(expected, Solution().minBitFlips(inputData.start, inputData.goal))
        }
    }

    data class InputData(val start: Int, val goal: Int)
}