package p966

class Solution {
    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        val result = Array(queries.size) { "" }

        val originalWords = mutableSetOf<String>()
        val lowerCaseWords = mutableMapOf<String, String>()
        val vowelFixedWords = mutableMapOf<String, String>()

        for (word in wordlist) {
            originalWords.add(word)
            val lowerCaseWord = word.lowercase()
            lowerCaseWords.putIfAbsent(lowerCaseWord, word)
            vowelFixedWords.putIfAbsent(devowel(lowerCaseWord), word)
        }

        for ((index, query) in queries.withIndex()) {
            if (originalWords.contains(query)) {
                result[index] = query
            } else {
                val lowerCaseQuery = query.lowercase()
                result[index] = lowerCaseWords[lowerCaseQuery] ?: vowelFixedWords[devowel(lowerCaseQuery)] ?: ""
            }
        }
        return result
    }

    private fun devowel(word: String): String {
        return word.replace("[aeiou]".toRegex(), "*")
    }
}