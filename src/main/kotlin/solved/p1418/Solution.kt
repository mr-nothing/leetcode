package solved.p1418

class Solution {
    fun displayTable(orders: List<List<String>>): List<List<String>> {
        // A tree set of all tables sorted by natural order
        val tables = sortedSetOf<Int>()
        // A tree set of all dishes sorted by natural order
        val dishes = sortedSetOf<String>()

        // Result map containing unsorted display table (mapOf(table to mapOf(dish to quantity))
        val resultMap = mutableMapOf<Int, MutableMap<String, Int>>()

        for (order in orders) {
            // Skip person name as we are not interested in it in the final solution
            // Parse table number
            val tableNumber = order[1].toInt()
            // Parse dish name
            val dishName = order[2]

            // Add table number to general table set
            tables.add(tableNumber)
            // Add dish to general dish set
            dishes.add(dishName)

            // Get already created table map info or initialize it with empty map
            val tableDishes = resultMap.getOrDefault(tableNumber, mutableMapOf())
            // Get dish quantity already found for this table or initialize it with zero
            val dishQuantity = tableDishes.getOrDefault(dishName, 0)
            // Set dish quantity info and increment it by one
            tableDishes[dishName] = dishQuantity + 1
            // Set table info
            resultMap[tableNumber] = tableDishes
        }

        // Initializing result list of list
        val result = mutableListOf<MutableList<String>>()

        // Create header table
        val header = mutableListOf<String>()
        // Add "Table" string since it is one of the requirements
        header.add("Table")
        for (dish in dishes) {
            // Add all the dishes' names sorted alphabetically
            header.add(dish)
        }
        // Add header to the result table
        result.add(header)

        // Go through all the tables and populate rows corresponding to each table
        for (table in tables) {
            // Initialize table row with zeroes at first
            // dishes.size + 1 is because we have first column populated with table numbers
            val resultRow = MutableList(dishes.size + 1) { "0" }
            // Populate table number
            resultRow[0] = table.toString()

            // Get all the dishes ordered for this table
            val tableDishes = resultMap[table]!!
            for (entry in tableDishes) {
                // Get "alphabetical" dish index to place it to the right position in the final table
                val dishIndex = dishes.indexOf(entry.key) + 1

                // Populate the quantity of dishes ordered for this table (at corresponding index)
                resultRow[dishIndex] = entry.value.toString()
            }
            // Add populated row to the final table
            result.add(resultRow)
        }

        return result
    }
}