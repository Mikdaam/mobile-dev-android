package fr.android.onlydigits

class CountSolver {
    // This function takes the target number and a list of integers that represent the plates.
    // It returns a list of CountResult objects that represent all possible ways to use the plates
    // to reach the target number.
    fun solve(target: Int, tiles: List<Int>): List<CountResult> {
        val results = mutableListOf<CountResult>()

        // If there is only one plate, we can only reach the target if the plate's value is equal to the target.
        if (tiles.size == 1) {
            if (tiles[0] == target) {
                results.add(CountResult(listOf(), target))
            }
            return results
        }

        // Iterate over all pairs of plates, and over all operators.
        // For each pair and operator, calculate the result of the operation, and add it as a new plate.
        for (i in tiles.indices) {
            for (j in i + 1 until tiles.size) {
                val operand1 = tiles[i]
                val operand2 = tiles[j]

                for (op in Operator.values()) {
                    val opResult = Operation(operand1, op, operand2).result ?: continue

                    // Create a new list of plates that includes the result of the operation.
                    val newTiles = mutableListOf<Int>()
                    for (k in tiles.indices) {
                        if (k != i && k != j) {
                            newTiles.add(tiles[k])
                        }
                    }
                    newTiles.add(opResult)

                    // Recursively call this function with the new list of plates.
                    // For each CountResult returned, add the current operation to its list of operations,
                    // and add the result to the list of results.
                    val subResults = solve(target, newTiles)
                    for (subResult in subResults) {
                        val operations = subResult.operations.toMutableList()
                        operations.add(Operation(operand1, op, operand2))
                        results.add(CountResult(operations, subResult.result))
                    }

                    // If the result of the operation equals the target, add a new CountResult with only this operation.
                    if (opResult == target) {
                        results.add(CountResult(listOf(Operation(operand1, op, operand2)), target))
                    }
                }
            }
        }

        return results
    }
}

data class CountResult(val operations: List<Operation>, val result: Int)

data class Operation(val operand1: Int, val operator: Operator, val operand2: Int) {
     val result: Int? get() = when(operator) {
        Operator.ADD -> operand1 + operand2
        Operator.SUB -> if (operand1 < operand2) null else operand1 - operand2
        Operator.MUL -> operand1 * operand2
        Operator.DIV -> if (operand2 == 0 || operand1 % operand2 != 0) null else operand1 / operand2
     }?.takeIf { it >= 0 }

    override fun toString(): String {
        return "$operand1 ${operator.symbol} $operand2 = $result"
    }
}

enum class Operator(val symbol: String) {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    companion object {
        fun fromString(symbol: String): Operator {
            return when (symbol) {
                "+" -> ADD
                "-" -> SUB
                "*" -> MUL
                "/" -> DIV
                else -> throw IllegalArgumentException("Invalid operator symbol: $symbol")
            }
        }
    }
}
