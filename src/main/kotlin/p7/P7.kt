package p7

import kotlin.math.pow

class Solution {
    fun reverse(x: Int): Int {
        var result = 0

        val digitsList = mutableListOf<Int>()
        if (x == 0) {
            return 0
        }

        val divisor = 10
        var divident = x
        while (divident != 0) {
            val mod = (divident % divisor)
            digitsList.add(mod)
            divident = (divident - mod) / 10
        }

        val factor = 10
        for (i in digitsList.size - 1 downTo 0) {
            val digit = digitsList[digitsList.size - 1 - i]
            val resultPart = digit * factor.toDouble().pow(i.toDouble())
            if (resultPart < Int.MIN_VALUE || resultPart > Int.MAX_VALUE) {
                return 0
            }
            if (x > 0 && Int.MAX_VALUE - result - resultPart < 0) {
                return 0
            }
            if (x < 0 && Int.MIN_VALUE - result - resultPart > 0) {
                return 0
            }
            result += resultPart.toInt()
        }

        return result
    }
}