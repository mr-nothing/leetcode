package p703

import java.util.PriorityQueue

class HeapSolution {
    class KthLargest(private val k: Int, nums: IntArray) {
        private val heap = PriorityQueue<Int>()

        init {
            for (num in nums) {
                addInternal(num)
            }
        }

        fun add(`val`: Int): Int {
            return addInternal(`val`)
        }

        private fun addInternal(num: Int): Int {
            heap.offer(num)
            if (heap.size > k) {
                heap.poll()
            }
            return heap.peek()
        }
    }
}