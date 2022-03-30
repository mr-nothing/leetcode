package p8

import kotlin.math.pow

class Solution {
    fun myAtoi(s: String): Int {
        var positive: Boolean? = null
        val numberChars = mutableListOf<Int>()

        for (ch in s) {
            if (ch == ' ' && numberChars.isEmpty() && positive == null) {
                continue
            }
            if (ch.isDigit()) {
                numberChars += ch - '0' // digitToInt() doesn't work for some reason on LeetCode, it seems they have kotlin lower than 1.5
            } else {
                if (positive == null && numberChars.isEmpty()) {
                    positive = when (ch) {
                        '-' -> false
                        '+' -> true
                        else -> return 0
                    }
                } else {
                    break
                }
            }
        }

        if (positive == null) {
            positive = true
        }

        var result = 0
        for (i in numberChars.size - 1 downTo 0) {
            val digit = numberChars[numberChars.size - 1 - i]
            if (result == 0 && digit == 0) {
                continue
            }

            val addition = digit * 10.toDouble().pow(i.toDouble())
            if (positive == true && Int.MAX_VALUE - result - addition < 0) {
                return Int.MAX_VALUE
            }
            if (positive == false && Int.MIN_VALUE + result + addition > 0) {
                return Int.MIN_VALUE
            }

            result += addition.toInt()
        }

        return if (positive) result else -result
    }
}