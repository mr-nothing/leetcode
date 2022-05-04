package solved.p950

import java.util.*

class Solution {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val sorted = deck.sorted()

        val list = LinkedList<Int>()

        list.addFirst(sorted[sorted.lastIndex])
        for (i in sorted.lastIndex - 1 downTo 0) {
            list.addFirst(list.pollLast()) // move from bottom to the top
            list.addFirst(sorted[i]) // unreveal
        }

        return list.toIntArray()
    }
}