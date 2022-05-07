package solved.p1209

import java.util.*

class Solution {
    private val stack = LinkedList<Pair<Char, Int>>()

    // The idea is to create stack that holds chars from initial string as long as we didn't meet required number of
    // duplicated chars. The element of stack is a pair of char itself and position of its char in a duplicate chain.
    // Duplicates are cleaned up as soon as we meet k chars.
    // Example: aabddcee, k = 2
    // add a    :   (a,1)
    // add a    :   (a,1) (a,2)
    // cleanup  :
    // add b    :   (b,1)
    // add d    :   (b,1)(d,1)
    // add d    :   (b,1)(d,1)(d,2)
    // cleanup  :   (b,1)
    // add c    :   (b,1)(c,1)
    // add e    :   (b,1)(c,1)(e,1)
    // add e    :   (b,1)(c,1)(e,1)(e,2)
    // cleanup  :   (b,1)(c,1)
    // End of the algorithm.
    fun removeDuplicates(s: String, k: Int): String {
        for (char in s) {
            val previous = stack.peekLast()
            if (previous != null && previous.first == char) {
                if (previous.second + 1 == k) {
                    while (stack.peekLast() != null && stack.peekLast().first == char) {
                        stack.removeLast()
                    }
                    continue
                } else {
                    stack.addLast(Pair(previous.first, previous.second + 1))
                }
            } else {
                stack.addLast(Pair(char, 1))
            }
        }
        return String(stack.map { pair -> pair.first }.toCharArray())
    }
}