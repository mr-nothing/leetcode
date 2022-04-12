package solved.p7

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class P7Test {
    @TestFactory
    fun `test solution`() = listOf(
        123 to 321,
        -3928 to -8293,
        120 to 21,
        -2980 to -892,
        Int.MAX_VALUE to 0,
        Int.MIN_VALUE to 0,
        2147457412 to 0,
        2147437412 to 2147347412,
        -2147457412 to 0,
        -2147437412 to -2147347412
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("Reversed version of $inputData should be $expected") {
            Assertions.assertEquals(expected, Solution().reverse(inputData))
        }
    }
}