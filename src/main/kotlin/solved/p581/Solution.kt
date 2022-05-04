package solved.p581

class Solution {
    class SortingApproach {
        // The idea is to sort initial array and compare both arrays from the start and from the end.
        // The index of first element from the:
        // - start that is not equal is the lower bound of the subsequence
        // - end that if not equal is the upper bound of the subsequence
        fun findUnsortedSubarray(nums: IntArray): Int {
            val sorted = nums.sorted()

            var lowerBound = -1
            for (i in 0..nums.lastIndex) {
                if (nums[i] != sorted[i]) {
                    lowerBound = i
                    break
                }
            }

            var upperBound = -1
            for (i in nums.lastIndex downTo 0) {
                if (nums[i] != sorted[i]) {
                    upperBound = i
                    break
                }
            }

            return if (lowerBound == upperBound) 0 else upperBound - lowerBound + 1
        }
    }

    class TwoPointerApproach {
        // The idea is to find:
        // - the element that should be going next to the sorted part at the start of array
        // - the element that should be going right before the sorted part at the end of array
        // Lets describe the algorithm for the first part.
        // 1. It is easy if min element is somewhere in the middle, we just need to sort from the very beginning.
        // 2. In case the second minimal element is somewhere in the middle and lower elements are sorted in the beginning of array, then we need to sort from the second element.
        // ...
        // n. In case the nth minimal element is somewhere in the middle and lower elements are sorted in the beginning of array, then we need to sort from the nth element.
        //
        // So to find this element and its index we need to go through the array and if current element is lower than maximal element met, then this can be the upper bound of the subarray we need to sort if nothing similar will be met further.
        // For the lower bound - if current element is greater than minimal element met, then this can be the lower bound if nothing similar will be met further.
        fun findUnsortedSubarray(nums: IntArray): Int {
            var lowerBound = -1
            var upperBound = -1

            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            for (i in 0..nums.lastIndex) {

                val headPointer = i
                val headValue = nums[headPointer]

                if (headValue > max) {
                    max = headValue
                } else if (headValue < max) {
                    upperBound = headPointer
                }

                val tailPointer = nums.lastIndex - i
                val tailValue = nums[tailPointer]

                if (tailValue < min) {
                    min = tailValue
                } else if (tailValue > min) {
                    lowerBound = tailPointer
                }

            }

            return if (upperBound == lowerBound) 0 else upperBound - lowerBound + 1
        }
    }
}