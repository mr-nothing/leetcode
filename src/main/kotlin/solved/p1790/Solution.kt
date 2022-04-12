package p1790

class Solution {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        var differences = 0

        val diffChars1 = mutableListOf<Char>()
        val diffChars2 = mutableListOf<Char>()
        for (i in 0..s1.lastIndex) {
            val ch1 = s1[i]
            val ch2 = s2[i]
            if (ch1 != ch2) {
                differences++
                if (differences > 2) {
                    return false
                }
                diffChars1.add(ch1)
                diffChars2.add(ch2)
            }
        }


        if (differences == 1) {
            return false
        }


        return differences == 0 || (differences == 2 && diffChars1[0] == diffChars2[1] && diffChars2[0] == diffChars1[1])
    }
}