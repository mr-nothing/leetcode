package solved.p2300

class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val result = IntArray(spells.size)
        val sortedSpells =
            spells.mapIndexed { index: Int, spell: Int -> index to spell }.sortedByDescending { it.second }
        val sortedPotions = potions.sortedDescending()

        var successfulMixes = 0
        for (spellEntry in sortedSpells) {
            val spell = spellEntry.second

            if (spell < success) {
                for (potion in sortedPotions) {
                    val product = spell * potion.toLong()

                    if (product >= success) {
                        successfulMixes++
                    } else {
                        break
                    }
                }
            } else {
                successfulMixes = potions.size
            }

            if (successfulMixes == 0) {
                break
            }

            result[spellEntry.first] = successfulMixes
            successfulMixes = 0
        }

        return result
    }
}