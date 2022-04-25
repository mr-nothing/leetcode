package solved.p2241

import kotlin.math.min

class Solution {
    class ATM {
        private val denominations = intArrayOf(20, 50, 100, 200, 500)
        private val banknotesVariants = denominations.size
        private val currentAmount = LongArray(banknotesVariants)

        fun deposit(banknotesCount: IntArray) {
            for (i in 0..currentAmount.lastIndex) {
                currentAmount[i] = currentAmount[i] + banknotesCount[i]
            }
        }

        fun withdraw(amount: Int): IntArray {
            val toWithdraw = IntArray(banknotesVariants)
            var remainingAmountToWithdraw = amount
            for (i in toWithdraw.lastIndex downTo 0) {
                val banknotesQuantity =
                    min((remainingAmountToWithdraw / denominations[i]).toLong(), currentAmount[i]).toInt()
                toWithdraw[i] = banknotesQuantity
                remainingAmountToWithdraw -= banknotesQuantity * denominations[i]
                if (remainingAmountToWithdraw <= 0) {
                    break
                }
            }

            if (remainingAmountToWithdraw != 0) {
                return intArrayOf(-1)
            }

            for (i in 0..currentAmount.lastIndex) {
                currentAmount[i] = currentAmount[i] - toWithdraw[i]
            }
            return toWithdraw
        }
    }
}