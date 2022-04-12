package solved.p6

class Solution {
    fun convert(s: String, numRows: Int): String {
        val decomposedStrings = mutableListOf<String>()

        if (numRows == 1) {
            return s
        }

        for (i in 0 until numRows) {
            decomposedStrings.add(i, "")
        }

        var forward = true

        val forwardCharCounterThreshold = numRows - 2
        val backwardCharCounterThreshold = 1
        var charCounter = 0
        for (ch in s) {
            decomposedStrings[charCounter] = decomposedStrings[charCounter].plus(ch)

            if (forward) {
                if (charCounter == forwardCharCounterThreshold) {
                    forward = forward.not()
                }
                charCounter++
            } else {
                if (charCounter == backwardCharCounterThreshold) {
                    forward = forward.not()
                }
                charCounter--
            }
        }

        return decomposedStrings.joinToString(separator = "")
    }
}