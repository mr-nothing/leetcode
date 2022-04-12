package solved.p9

/**
 * Solution with string conversion
 */
class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }

        val s = x.toString()
        if (s.length == 1) {
            return true
        }

        val iterationThreshold = s.lastIndex / 2
        for (i in 0..iterationThreshold) {
            val leftChar = s[i]
            val rightChar = s[s.lastIndex - i]

            if (leftChar != rightChar) {
                return false
            }
        }
        return true
    }

    fun isPalindrome2(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        if (x < 10) {
            return true
        }

        val digitList = mutableListOf<Int>()
        var divident = x
        val divisor = 10
        while(divident > 0) {
            val mod = divident % divisor
            digitList.add(mod)

            divident /= divisor
        }

        val iterationThreshold = digitList.lastIndex / 2
        for (i in 0..iterationThreshold) {
            val leftChar = digitList[i]
            val rightChar = digitList[digitList.lastIndex - i]

            if (leftChar != rightChar) {
                return false
            }
        }
        return true
     }
}