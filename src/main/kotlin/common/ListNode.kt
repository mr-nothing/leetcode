package common

class ListNode(var `val`: Int) {
    var next: ListNode? = null


    companion object {
        fun to(node: ListNode): List<Int> {
            val result = mutableListOf<Int>()
            var currentNode = node
            while (true) {
                result.add(currentNode.`val`)
                currentNode.next?.let {
                    currentNode = it
                } ?: break
            }
            return result
        }

        fun from(values: List<Int>): ListNode? {
            val digit = values.firstOrNull()
            digit?.let {
                val currentNode = ListNode(digit)
                currentNode.next = from(values.subList(1, values.size))
                return currentNode
            }
            return null
        }
    }

    override fun toString(): String {
        val builder = StringBuilder()
        var current = this
        builder.append("[")
        while (true) {
            builder.append(current.`val`)
            if (current.next == null) {
                break
            }
            current = current.next!!
            builder.append(",")
        }
        builder.append("]")
        return builder.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListNode

        if (`val` != other.`val`) return false
        if (next != other.next) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }


}