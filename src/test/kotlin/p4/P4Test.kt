package p4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class P4Test {
    @TestFactory
    fun `test solution`() = listOf(
        TestInput(arrayOf(1, 3), arrayOf(2)) to 2.0,
        TestInput(arrayOf(1, 2), arrayOf(3, 4)) to 2.5,
        TestInput(arrayOf(10), arrayOf()) to 10.0,
        TestInput(arrayOf(), arrayOf(12)) to 12.0,
        TestInput(arrayOf(-10, 5, 12, 66), arrayOf(-50, 46, 65)) to 12.0,
        TestInput(arrayOf(-45, -23, 23, 65), arrayOf(0, 12, 54, 65)) to 17.5,
    ).map { (inputData, expected) ->
        DynamicTest.dynamicTest("The median of arrays $inputData is $expected") {
            val actual = Solution().findMedianSortedArrays(
                inputData.a1.toIntArray(),
                inputData.a2.toIntArray()
            )

            assertEquals(expected, actual)
        }
    }


    data class TestInput(val a1: Array<Int>, val a2: Array<Int>)
}