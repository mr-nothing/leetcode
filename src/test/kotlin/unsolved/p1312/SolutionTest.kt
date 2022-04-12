package unsolved.p1312

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class SolutionTest {
    @TestFactory
    fun `test solution`() = listOf(
        "dyyuyabzkqaybcspq" to 12,
        "zzazz" to 0,
        "mbadm" to 2,
        "leetcode" to 5,
        "leetccde" to 4,
        "leetcdce" to 3,
        "uyyrbbmddk" to 8
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("To get a palindrome from $inputData it should be enough to make $expected insertions") {
            Assertions.assertEquals(expected, Solution().minInsertions(inputData))
        }
    }
}