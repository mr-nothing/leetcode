package solved.p1679

class Solution {
    class SortingApproach {
        fun maxOperations(nums: IntArray, k: Int): Int {
            val sorted = nums.sorted()

            var operations = 0

            var head = 0
            var tail = nums.lastIndex
            while (head < tail) {
                while (tail > head) {
                    val headValue = sorted[head]
                    val tailValue = sorted[tail]
                    val kSum = headValue + tailValue
                    if (kSum > k) { // if sum is greater than k then we need a lower number thus we need to move tail to the left
                        tail--
                    } else if (kSum < k) { // if sum is lower than k then we need a greater number thus we need to move tail to the right
                        head++
                    } else { // we found 2 numbers that sum up to k this move both head and tail pointers
                        operations++
                        head++
                        tail--
                    }
                }
            }

            return operations
        }
    }

    class HashMapApproach {
        fun maxOperations(nums: IntArray, k: Int): Int {
            val frequencies = hashMapOf<Int, Int>()
            var operations = 0

            for (first in nums) {
                val second = k - first
                val secondFrequency = frequencies.getOrDefault(second, 0) // get second number frequency
                if (secondFrequency > 0) {
                    // if number has been already met (frequency > 0) then decrement frequency and increment result
                    // since we found a pair that sum up to k
                    frequencies[second] = secondFrequency - 1
                    operations++
                } else {
                    // if we have not met number yet, than increment numbers frequency
                    val firstFrequency = frequencies.getOrDefault(first, 0)
                    frequencies[first] = firstFrequency + 1
                }
            }

            return operations
        }
    }
}