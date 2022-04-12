package p1790

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        InputData("bank", "kanb") to true,
        InputData("attack", "defend") to false,
        InputData("kelb", "kelb") to true,
        InputData("aa", "ac") to false
    ).map { (inputData, expected) ->
        val not = if (!expected) "not" else ""
        DynamicTest.dynamicTest("It should be $not possible to make ${inputData.s1} from ${inputData.s2} with one string swap") {
            Assertions.assertEquals(expected, Solution().areAlmostEqual(inputData.s1, inputData.s2))
        }
    }

    data class InputData(val s1: String, val s2: String)
}