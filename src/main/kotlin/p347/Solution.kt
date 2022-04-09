package p347

import java.util.PriorityQueue

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencies = mutableMapOf<Int, Int>()

        for (number in nums) {
            frequencies[number] = frequencies.getOrDefault(number, 0) + 1
        }

        val heap = PriorityQueue<NumberFrequency>(nums.size) { a, b -> a.frequency - b.frequency}
        for (entry in frequencies) {
            heap.offer(NumberFrequency(entry.key, entry.value))
            if (heap.size > k) {
                heap.poll()
            }
        }

        return heap.map { it.value }.toIntArray()
    }

    data class NumberFrequency(val value: Int, val frequency: Int)
}