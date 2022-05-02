package solved.p905

import java.util.*

class Solution {
    class AdditionalLinkedListApproach {
        fun sortArrayByParity(nums: IntArray): IntArray {
            val result = LinkedList<Int>()
            for (num in nums) {
                if (num % 2 == 0) {
                    result.addFirst(num)
                } else {
                    result.addLast(num)
                }
            }
            return result.toIntArray()
        }
    }

    class InPlaceSwapApproach {
        fun sortArrayByParity(nums: IntArray): IntArray {
            var headPointer = 0
            var tailPointer = nums.lastIndex

            while (headPointer < tailPointer) {
                val headValue = nums[headPointer]
                val tailValue = nums[tailPointer]
                if (headValue % 2 == 0) {
                    headPointer++
                } else {
                    if (tailValue % 2 == 1) {
                        tailPointer--
                    } else {
                        val temp = nums[headPointer]
                        nums[headPointer] = nums[tailPointer]
                        nums[tailPointer] = temp
                        headPointer++
                        tailPointer--
                    }
                }
            }
            return nums
        }
    }
}