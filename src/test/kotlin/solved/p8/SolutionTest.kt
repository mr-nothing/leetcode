package solved.p8

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        "     -28614563 some text" to -28614563,
        "42" to 42,
        "   -42" to -42,
        "4193 with words" to 4193,
        "   2837648192735627345 exceeds max int" to 2147483647,
        " -38746258976345824 exceed min int" to -2147483648,
        "there are only words here" to 0,
        "there are digits only at the end 298347823" to 0,
        "-+1232" to 0,
        "  -0 429734" to 0,
        "  -234 837438 bhejvbr" to -234,
        "  -   37643" to 0
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The number from $inputData should be $expected") {
            Assertions.assertEquals(expected, Solution().myAtoi(inputData))
        }
    }
}