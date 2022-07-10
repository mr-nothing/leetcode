package solved.p152

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max = nums[0]
        var min = nums[0]
        var ans = nums[0]
        for (i in 1 until nums.size) {
            val temp = max
            max = max(max(max * nums[i], min * nums[i]), nums[i])
            min = min(min(temp * nums[i], min * nums[i]), nums[i])
            if (max > ans) {
                ans = max
            }
        }
        return ans
    }
}