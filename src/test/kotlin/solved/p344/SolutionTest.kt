package solved.p344

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        charArrayOf('h', 'e', 'l', 'l', 'o') to charArrayOf('o', 'l', 'l', 'e', 'h'),
        charArrayOf('H', 'a', 'n', 'n', 'a', 'h') to charArrayOf('h', 'a', 'n', 'n', 'a', 'H')
    ).map { (input, expected) ->
        dynamicTest("The reversed version of $input should be $expected") {
            Solution().reverseString(input)
            assertArrayEquals(expected, input)
        }
    }
}