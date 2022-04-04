package p1721

import common.ListNode

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
        while (true) {
            if (nodesCounter == k) {
                first = currentNode
            }
            if (currentNode.next == null) {
                break
            }

            currentNode = currentNode.next!!
            nodesCounter++
        }

        val size = nodesCounter

        nodesCounter = 1
        currentNode = head
        // Second run through linked list to get the second node to swap
        while (true) {
            if (nodesCounter == size - k + 1) {
                last = currentNode
            }
            if (currentNode.next == null) {
                break
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