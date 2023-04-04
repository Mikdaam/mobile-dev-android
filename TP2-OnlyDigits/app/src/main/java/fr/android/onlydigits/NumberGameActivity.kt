package fr.android.onlydigits

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class NumberGameActivity : AppCompatActivity() {

    // Properties with view binding using the KTX extension functions.
    private val newTargetButton by lazy { findViewById<Button>(R.id.new_target) }
    private val undoButton by lazy { findViewById<Button>(R.id.undo) }
    private val solveButton by lazy { findViewById<Button>(R.id.solve) }
    private val targetText by lazy { findViewById<TextView>(R.id.target_text) }
    private val plateletButtonsTextId = listOf(R.string.one, R.string.two, R.string.three, R.string.four, R.string.five, R.string.six)
    private val plateletButtons by lazy {
        listOf(R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six).map { id ->
            findViewById<Button>(id)
        }
    }
    private val operatorButtons by lazy {
        listOf(R.id.add, R.id.sub, R.id.mul, R.id.div).map { id ->
            findViewById<Button>(id)
        }
    }
    private val stepsText by lazy { findViewById<TextView>(R.id.steps) }
    private val winningText by lazy { findViewById<TextView>(R.id.won) }

    // Initialize properties with constant values.
    private var targetNumber = generateTargetNumber()
    private var currentLeftOperandIndex = -1
    private lateinit var currentState: State
    private val states = ArrayList<State>()
    private var currentPlateletButtonState = List(6) { true }
    private val plateletButtonStates = ArrayList<List<Boolean>>()
    private var operatorActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_game)

        currentState = State(generatePlateletValues(this), listOf())
        states.add(currentState)
        plateletButtonStates.add(currentPlateletButtonState)

        displayState(currentPlateletButtonState)

        // Handle the "New Target" button click event using a separate method.
        newTargetButton.setOnClickListener { handleNewTargetButton(this) }

        // Handle the "Undo" button click event using a separate method.
        undoButton.setOnClickListener { handleUndoButton() }

        // Handle the "Solve" button click event using a separate method.
        solveButton.setOnClickListener { handleSolveButton() }

        // Handle the platelet button click events using a separate method.
        plateletButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                handlePlateletButton(index, button.text.toString().toInt())
            }
        }

        // Handle the operator button click events using a separate method.
        operatorButtons.forEach { button ->
            button.setOnClickListener {
                handleOperatorButton(button.text.toString())
            }
        }
    }

    private fun displayState(buttonsState: List<Boolean>) {
        // target number
        targetText.text = resources.getString(R.string.target_number, targetNumber)

        val isUndoable = states.size > 1
        undoButton.toggle(isUndoable)

        // tiles buttons
        plateletButtons.forEachIndexed { index, button ->
            button.text = getString(plateletButtonsTextId[index], currentState.plateletValues[index])
            button.toggle(buttonsState[index])
        }

        // operators button
        operatorButtons.forEach { it.toggle(operatorActive) }

        stepsText.text = currentState.operations.joinToString("\n")

        val res = currentState.operations.lastOrNull()?.result
        if (targetNumber == res)
            winningText.text = getString(R.string.win)
    }

    // Initialize the game elements using the resources.
    private fun generatePlateletValues(context: Context): List<Int> {
        return ElementPicker.buildFromResources(
            context,
            R.raw.numberfrequencies
        ) { s -> s.toInt() }.pickElements(6)
    }

    // Generate a random target number.
    private fun generateTargetNumber(): Int {
        return (101..999).random()
    }

    // Handle the "New Target" button click event.
    private fun handleNewTargetButton(context: Context) {
        states.clear()
        plateletButtonStates.clear()

        targetNumber = generateTargetNumber()
        currentState = State(generatePlateletValues(context), listOf())
        currentPlateletButtonState = List(6) { true }
        operatorActive = false

        states.add(currentState)
        plateletButtonStates.add(currentPlateletButtonState)

        solveButton.toggle(true)
        displayState(currentPlateletButtonState)
    }

    // Handle the platelet button click event.
    private fun handlePlateletButton(plateletIndex: Int, plateletValue: Int) {
        val s = currentState
        if (currentState.leftOperand == null) {
            // get left operand
            currentState = currentState.copy(leftOperand = plateletValue)

            currentLeftOperandIndex = plateletIndex
            operatorActive = !operatorActive

            displayState(currentPlateletButtonState.map { false })
        } else if (s.operator != null && s.leftOperand != null) {
            // compute the operation if it write value
            val operation = Operation(s.leftOperand, Operator.fromString(s.operator), plateletValue)
            val result = operation.result

            if (result == null) {
                Toast.makeText(this, "Can't perform that operation", Toast.LENGTH_LONG).show()
                operatorActive = !operatorActive
                operatorButtons.forEach { it.toggle(operatorActive) }
                return;
            }

            val newValues = currentState.plateletValues.mapIndexed { index, value ->
                if (index == currentLeftOperandIndex) result else value
            }
            currentState = currentState.copy(
                leftOperand = null,
                operator = null,
                plateletValues = newValues,
                operations = currentState.operations + operation
            )
            states += currentState

            currentPlateletButtonState = currentPlateletButtonState.mapIndexed { index, value ->
                if (index == plateletIndex) false else value
            }
            plateletButtonStates.add(currentPlateletButtonState)

            displayState(currentPlateletButtonState)
        }
    }

    // Handle the operator button click event.
    private fun handleOperatorButton(operator: String) {
        currentState = currentState.copy(operator = operator)

        operatorActive = !operatorActive
        displayState(currentPlateletButtonState.mapIndexed { index, value -> if (index == currentLeftOperandIndex) false else value })
    }

    // Handle the undo button click event.
    private fun handleUndoButton() {
        val prevStateId = states.lastIndex - 1

        currentState = states[prevStateId]
        currentPlateletButtonState = plateletButtonStates[prevStateId]

        states.removeLast()
        plateletButtonStates.removeLast()

        displayState(currentPlateletButtonState)
    }

    // Handle the solve button click event.
    private fun handleSolveButton() {
        solveButton.toggle(false)
        undoButton.toggle(false)
        plateletButtons.forEach { it.toggle(false) }

        val steps = CountSolver().solve(targetNumber, states.first().plateletValues)
        val solution = steps.firstOrNull()?.operations?.reversed()?.joinToString(separator = "\n")

        stepsText.text = if (solution != null) {
            getString(R.string.solution_text, solution)
        } else {
            getString(R.string.no_solution_text)
        }
    }

    /**
     *
     * Toggles the enabled and clickable state of a button.
     * @param active true if the button should be enabled and clickable, false otherwise
    */
    private fun Button.toggle(active: Boolean) {
        this.isEnabled = active
        this.isClickable = active
    }
}