package solved.p844

class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        // Initialize pointers to the last index. If we start processing with the first and not last character, then
        // we need to use additional power and break O(1) space requirement.
        var sPointer = s.lastIndex
        var tPointer = t.lastIndex

        while (true) {
            // Move pointer for both words
            sPointer = movePointer(sPointer, s)
            tPointer = movePointer(tPointer, t)

            // if any of pointers is lower than 0 or characters met doesn't match - finish loop processing
            // since words are not equal by length or by content accordingly
            if (sPointer >= 0 && tPointer >= 0 && s[sPointer] == t[tPointer]) {
                sPointer--
                tPointer--
            } else {
                break
            }
        }

        // the words can be treated equal only when both pointer processed whole words
        return sPointer == -1 && tPointer == -1
    }

    private fun movePointer(pointer: Int, str: String): Int {
        var currentPointer = pointer
        var backspaces = 0
        // if current pointer is greater than 0 AND (we met backspaces that was not processed yet OR current character is #) then continue processing
        while (currentPointer >= 0 && (backspaces > 0 || str[currentPointer] == '#')) {
            if (str[currentPointer] == '#') { // if # is met then increment backspaces
                backspaces++
            } else { // else decrement backspaces
                backspaces--
            }
            currentPointer-- // decrement pointer whatever we met
        }
        return currentPointer
    }
}