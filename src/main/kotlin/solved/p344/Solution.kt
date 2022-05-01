package solved.p344

class Solution {
    fun reverseString(s: CharArray) {
        var startIndex = 0
        var endIndex = s.lastIndex
        while (startIndex < endIndex) {
            val temp = s[startIndex]
            s[startIndex] = s[endIndex]
            s[endIndex] = temp
            startIndex++
            endIndex--
        }
    }
}