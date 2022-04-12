package solved.p1

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indexedMap: MutableMap<Int, Int> = HashMap()
        for (index in nums.indices) {
            val complement = target - nums[index]
            if (indexedMap.containsKey(complement)) {
                return intArrayOf(indexedMap[complement]!!, index)
            }
            indexedMap[nums[index]] = index
        }
        throw IllegalStateException("No solution found")
    }
}