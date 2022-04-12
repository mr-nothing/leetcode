package p2220

class Solution {
    fun minBitFlips(start: Int, goal: Int): Int {
        val result = start.xor(goal)
        return Integer.toBinaryString(result).count { c: Char -> c == '1' }
    }
}