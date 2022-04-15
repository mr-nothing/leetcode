package solved.p700

import common.TreeNode

class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        var current = root!!
        while (true) {
            if (`val` > current.`val`) {
                current.right?.let {
                    current = it
                } ?: return null
            } else if (`val` < current.`val`) {
                current.left?.let {
                    current = it
                } ?: return null
            } else {
                return current
            }
        }
    }
}