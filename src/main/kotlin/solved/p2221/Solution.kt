package solved.p2221

class Solution {
    fun triangularSum(nums: IntArray): Int {
        var currentArray = nums
        var newArray = IntArray(currentArray.size - 1)
        while (currentArray.size != 1) {
            for (i in 0 until currentArray.lastIndex) {
                newArray[i] = (currentArray[i] + currentArray[i + 1]) % 10
            }
            currentArray = newArray
            newArray = IntArray(currentArray.size - 1)
        }
        return currentArray[0]
    }
}