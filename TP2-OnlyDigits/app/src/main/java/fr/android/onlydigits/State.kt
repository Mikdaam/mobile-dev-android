package fr.android.onlydigits

data class State(
    val plateletValues: List<Int>,
    val operations: List<Operation>,
    val leftOperand: Int? = null,
    val operator: String? = null
)
