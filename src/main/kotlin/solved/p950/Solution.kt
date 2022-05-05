package solved.p950

import java.util.*

class Solution {
    // The idea is just to reverse the process described in the problem.
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val sorted = deck.sorted() // sort the array, the final state

        val list = LinkedList<Int>()

        list.addFirst(sorted[sorted.lastIndex]) // unreveal the largest card
        for (i in sorted.lastIndex - 1 downTo 0) {
            list.addFirst(list.pollLast()) // move card from the bottom to the top
            list.addFirst(sorted[i]) // unreveal next largest card
        }

        return list.toIntArray()
    }
}