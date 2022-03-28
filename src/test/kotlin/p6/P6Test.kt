package p6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class P6Test {
    @TestFactory
    fun `test solution`() = listOf(
        InputData("PAYPALISHIRING", 1) to "PAYPALISHIRING",
        InputData("PAYPALISHIRING", 2) to "PYAIHRNAPLSIIG",
        InputData("PAYPALISHIRING", 3) to "PAHNAPLSIIGYIR",
        InputData("PAYPALISHIRING", 4) to "PINALSIGYAHRPI"
    ).map { (input, expected) ->
        dynamicTest("The ${input.rows} row zig zag form of ${input.string} is $expected") {
            val actual = Solution().convert(input.string, input.rows)
            assertEquals(expected, actual)
        }
    }

    data class InputData(
        val string: String,
        val rows: Int
    )
}