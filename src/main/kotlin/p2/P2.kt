package p2

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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        return addTwoNumbersInternal(l1, l2, false)!!
    }

    private fun addTwoNumbersInternal(l1: ListNode?, l2: ListNode?, hasOverflow: Boolean): ListNode? {
        var currentValue = if (l1 != null && l2 != null) {
            l1.value + l2.value
        } else if (l1 != null) {
            l1.value
        } else if (l2 != null) {
            l2.value
        } else {
            0
        }

        if (hasOverflow) {
            currentValue += 1
        }

        if (l1?.value == null && l2?.value == null && currentValue == 0) {
            return null
        }

        val resultCurrentNode: ListNode
        if (currentValue > 9) {
            resultCurrentNode = ListNode(currentValue - 10)
            resultCurrentNode.next = addTwoNumbersInternal(l1?.next, l2?.next, true)
        } else {
            resultCurrentNode = ListNode(currentValue)
            resultCurrentNode.next = addTwoNumbersInternal(l1?.next, l2?.next, false)
        }

        return resultCurrentNode
    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}