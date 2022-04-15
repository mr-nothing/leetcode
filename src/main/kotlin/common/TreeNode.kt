package common

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun from(values: List<Int>): TreeNode? {
            if (values.isEmpty()) {
                return null
            }
            val root = TreeNode(values.first())
            for (i in 1..values.lastIndex) {
                add(root, values[i])
            }
            return root
        }

        private fun add(currentNode: TreeNode, nodeValue: Int) {
            if (nodeValue >= currentNode.`val`) {
                val right = currentNode.right
                right?.let {
                    add(it, nodeValue)
                } ?: let {
                    currentNode.right = TreeNode(nodeValue)
                }
            } else {
                val left = currentNode.left
                left?.let {
                    add(it, nodeValue)
                } ?: let {
                    currentNode.left = TreeNode(nodeValue)
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TreeNode

        if (`val` != other.`val`) return false
        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }
}