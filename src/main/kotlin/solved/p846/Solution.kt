package solved.p846

import java.util.*

class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) {
            return false
        }

        val heap = PriorityQueue<Int>()
        heap.addAll(hand.toList())

        val groups = LinkedList<LinkedList<Int>>()

        while (heap.isNotEmpty()) {
            val nextValuedCard = heap.poll()

            val group = groups.poll() ?: LinkedList()

            if (group.isNotEmpty()) {
                val groupLastCard = group.peekLast()
                when (nextValuedCard - groupLastCard) {
                    1 -> {
                        group.add(nextValuedCard)
                    }
                    0 -> {
                        val newGroup = LinkedList<Int>()
                        newGroup.add(nextValuedCard)
                        groups.add(newGroup)
                    }
                    else -> {
                        return false
                    }
                }
            } else {
                group.add(nextValuedCard)
            }

            if (group.size != groupSize) {
                groups.addLast(group)
            }
        }

        return groups.isEmpty()
    }
}