package solved.p2240

class Solution {
    fun waysToBuyPensPencils(total: Int, pencil: Int, pen: Int): Long {
        var result: Long = 0

        var multiplier = 0
        var pencilBudget = 0
        while (pencilBudget <= total) {
            val penBudget = total - pencilBudget
            result += (penBudget / pen) + 1
            pencilBudget = pencil * ++multiplier
        }
        return result
    }
}