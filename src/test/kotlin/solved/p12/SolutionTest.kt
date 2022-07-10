package solved.p12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {

    @TestFactory
    fun `test solution`() = listOf(
        3 to "III",
        58 to "LVIII",
        1994 to "MCMXCIV",
        3215 to "MMMCCXV"
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("The roman version of $input should be $expected") {
            assertEquals(expected, Solution().intToRoman(input))
        }
    }
}