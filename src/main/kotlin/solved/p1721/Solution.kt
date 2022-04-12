package solved.p1721

import common.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun swapNodes(head: ListNode, k: Int): ListNode {
        var first: ListNode? = null
        var last: ListNode? = null

        if (head.next == null) {
            return head
        }

        var nodesCounter = 1 // This is one since k is not zero indexed
        var currentNode: ListNode = head
        // First run through linked list to get the first node to swap and the length of the list
        while (currentNode.next != null) {
            if (nodesCounter == k) {
                first = currentNode
            }
            currentNode = currentNode.next!!
            nodesCounter++
        }

        val size = nodesCounter

        nodesCounter = 1
        currentNode = head
        // Second run through linked list to get the second node to swap
        while (currentNode.next != null) {
            if (nodesCounter == size - k + 1) {
                last = currentNode
            }
            currentNode = currentNode.next!!
            nodesCounter++
        }

        val firstValue = first!!.`val`
        val lastValue = last!!.`val`

        first.`val` = lastValue
        last.`val` = firstValue

        return head
    }
}