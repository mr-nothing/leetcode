package solved.p2

import common.ListNode

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        return addTwoNumbersInternal(l1, l2, false)!!
    }

    private fun addTwoNumbersInternal(l1: ListNode?, l2: ListNode?, hasOverflow: Boolean): ListNode? {
        var currentValue =
            if (l1 != null && l2 != null) {
                l1.`val` + l2.`val`
            } else if (l1 != null) {
                l1.`val`
            } else if (l2 != null) {
                l2.`val`
            } else {
                0
            }

        if (hasOverflow) {
            currentValue += 1
        }

        if (l1?.`val` == null && l2?.`val` == null && currentValue == 0) {
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