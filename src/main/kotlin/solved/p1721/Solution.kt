package solved.p1721

import common.ListNode

class Solution {
    fun swapNodes(head: ListNode, k: Int): ListNode {
        val first: ListNode
        val second: ListNode

        if (head.next == null) {
            return head
        }

        var counter = k // This is the counter to reach kth element
        var firstCurrentNode = head
        // First run through linked list to get the first node to swap
        while (--counter > 0) {
            firstCurrentNode = firstCurrentNode.next!!
        }
        first = firstCurrentNode

        var secondCurrentNode = head
        // Second run through linked list to get the second node to swap
        // While we move current node to the end, we move second node to it's size - k position
        while (firstCurrentNode.next != null) {
            firstCurrentNode = firstCurrentNode.next!!
            secondCurrentNode = secondCurrentNode.next!!
        }
        second = secondCurrentNode

        val temp = first.`val`
        first.`val` = second.`val`
        second.`val` = temp

        return head
    }
}