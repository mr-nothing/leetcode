package solved.p1046

import java.util.*

class PriorityQueueSolution {
    // Priority queue solution
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int>(stones.size) { a, b -> b - a }

        for (stone in stones) {
            heap.add(stone)
        }

        while (heap.size > 1) {
            val max1 = heap.remove()
            val max2 = heap.remove()

            val smash = max1 - max2
            if (smash == 0) {
                continue
            }

            heap.add(smash)
        }

        return if (heap.size == 1) {
            heap.peek()
        } else {
            0
        }
    }
}