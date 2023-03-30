package fr.android.onlydigits



data class Operation(val leftOperand: Int, val rightOperand: Int, val operator: String) {

    val result: Int get() = when(operator) {
        "+" -> leftOperand + rightOperand
        "-" -> leftOperand - rightOperand
        "*" -> leftOperand * rightOperand
        "/" -> leftOperand / rightOperand
        else -> 0
    }

    override fun toString(): String {
        return "$leftOperand $operator $rightOperand = $result\n"
    }
}

data class State(
    val plateletValues: MutableList<Int>,
    val operations: List<Operation>,
    val leftOperand: Int? = null,
    val operator: String? = null
) {}
