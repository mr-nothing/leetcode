package solved.p1658

import kotlin.math.max

class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val sum = nums.sum()

        var maxLength = -1
        var currSum = 0

        var left = 0
        var right = 0

        while (right < nums.size) {
            currSum += nums[right]

            while (left <= right && currSum > sum - x) {
                currSum -= nums[left]
                left++
            }

            if (currSum == sum - x) {
                maxLength = max(maxLength, right - left + 1)
            }

            right++
        }
        return if (maxLength == -1) -1 else nums.size - maxLength
    }
}