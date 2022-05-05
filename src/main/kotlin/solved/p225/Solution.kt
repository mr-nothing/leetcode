package solved.p225

import java.util.*

class Solution {
    // The idea is to iterate through the queue on push call to move the last added element to the top of the queue (kind of reverse it)
    // So the queue has the following state on each operation:
    // push 1:
    // - add        [1]
    // - reverse    [1]
    // push 2:
    // - add        [2, 1]
    // - reverse    [1, 2]
    // push 5:
    // - add        [5, 1, 2]
    // - reverse    [1, 2, 5]
    // etc..
    // In this state next pop/top operations can be called for free (0(1)).
    class MyStack {
        private val queue = LinkedList<Int>()

        fun push(x: Int) {
            queue.add(x)
            for (i in 0 until queue.lastIndex) {
                queue.add(queue.pollLast())
            }
        }

        fun pop(): Int {
            return queue.pollLast()
        }

        fun top(): Int {
            return queue.peekLast()
        }

        fun empty(): Boolean {
            return queue.isEmpty()
        }
    }
}