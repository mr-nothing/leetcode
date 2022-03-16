package p1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class P1Test {
    @TestFactory
    fun `test problem 1`() = listOf(
        TestData(arrayOf(2,7,11,15), 9, 0, 1),
        TestData(arrayOf(3,2,4), 6, 1, 2),
        TestData(arrayOf(3,3), 6, 0, 1)
    ).map {
        val array = it.array
        val firstIndex = it.firstIndex
        val secondIndex = it.secondIndex
        val target = it.target
        dynamicTest("$array should has sum of elements on index $firstIndex and $secondIndex equals to $target") {
            val indexes = Solution().twoSum(array.toIntArray(), target)

            assertEquals(indexes[0], firstIndex)
            assertEquals(indexes[1], secondIndex)
        }
    }

    data class TestData(
        val array: Array<Int>,
        val target: Int,
        val firstIndex: Int,
        val secondIndex: Int
    )
}