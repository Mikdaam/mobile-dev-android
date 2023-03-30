package fr.android.onlydigits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class NumberGameActivity : AppCompatActivity() {
    private val newTargetButton by lazy { findViewById<Button>(R.id.new_target) }
    private val targetText by lazy { findViewById<TextView>(R.id.target_text) }
    private val plateletButtonsString = listOf(R.string.one, R.string.two, R.string.three, R.string.four, R.string.five, R.string.six)
    private val plateletButtonsId = listOf(R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six)
    private val plateletButtons by lazy { plateletButtonsId.map { id -> findViewById<Button>(id) } }
    private val plateletActive = mutableListOf(true, true, true, true, true, true)
    private val operatorButtonIds = listOf(R.id.add, R.id.sub, R.id.mul, R.id.div)
    private val operatorButtons by lazy { operatorButtonIds.map { id -> findViewById<Button>(id) } }
    private var opActive = false
    private val stepsText by lazy { findViewById<TextView>(R.id.steps) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_game)

        val elements = ElementPicker.buildFromResources(this, R.raw.numberfrequencies) { s -> s.toInt()}
        val interval = 101..999
        val nbOfPlatelets = 6

        var targetNumber = interval.random()
        val states = ArrayList<State>();
        var currentState = State(elements.pickElements(nbOfPlatelets) as MutableList<Int>, listOf())

        displayState(currentState, targetNumber)
        operatorButtons.forEach { btn -> toggleButton(btn, opActive) }

        newTargetButton.setOnClickListener {
            states.clear()
            currentState = State(elements.pickElements(nbOfPlatelets) as MutableList<Int>, listOf())
            targetNumber = interval.random();
            opActive = false

            displayState(currentState, targetNumber)

            operatorButtons.forEach { btn -> toggleButton(btn, opActive) }
        }

        var leftId = -1

        // listener on platelet buttons
        for (button in plateletButtons) {
            button.setOnClickListener {
                val value = button.text.toString().toInt();
                val s = currentState
                if (currentState.leftOperand == null) {
                    leftId = plateletButtonsId.indexOf(button.id)

                    opActive = !opActive
                    disableButtons(plateletButtons)

                    // get left value
                    currentState = currentState.copy(leftOperand = value)
                    operatorButtons.forEach { btn -> toggleButton(btn, opActive) }
                } else {
                    // compute the operation if it write value
                    if (s.operator != null && s.leftOperand != null) {
                        val operation = Operation(s.leftOperand, value, s.operator)

                        currentState.plateletValues[leftId] = operation.result
                        currentState = currentState.copy(leftOperand = null, operator = null, operations = currentState.operations + operation)

                        plateletActive[leftId] = true
                        plateletActive[plateletButtonsId.indexOf(button.id)] = false
                        displayState(currentState, targetNumber)

                        states += currentState
                    }
                }
            }
        }

        // listener on operator buttons
        for (button in operatorButtons) {
            button.setOnClickListener {
                val op = button.text.toString()

                currentState = currentState.copy(operator = op)

                opActive = !opActive
                enableButtons(plateletButtons)
                plateletActive[leftId] = false
                displayState(currentState, targetNumber)
                // operator buttons
                operatorButtons.forEach { btn -> toggleButton(btn, opActive) }
            }
        }
    }

    private fun displayState(s: State, targetNumber: Int) {
        // target number
        targetText.text = resources.getString(R.string.target_number, targetNumber)

        // tiles buttons
        for (i in plateletButtons.indices) {
            plateletButtons[i].text = resources.getString(plateletButtonsString[i], s.plateletValues[i])
            // toggle all the buttons
            toggleButton(plateletButtons[i], plateletActive[i])
        }

        // display steps
        val steps = StringBuilder();
        s.operations.forEach(steps::append)
        stepsText.text = steps.toString()
    }

    /*private fun displayDraw(targetNumber: Int, plateletsNumbers: List<Int>) {
        targetText.text = resources.getString(R.string.target_number, targetNumber)
        for (i in plateletButtons.indices) {
            plateletButtons[i].text = resources.getString(plateletButtonsString[i], plateletsNumbers[i])
        }
    }*/

    private fun undo(s: State) {

    }

    private fun disableButtons(buttons: List<Button>) {
        for (button in buttons) {
            disableButton(button)
        }
    }

    private fun disableButton(button: Button) {
        button.isEnabled = false
        button.isClickable = false
    }

    private fun enableButtons(buttons: List<Button>) {
        for (button in buttons) {
            enableButton(button)
        }
    }

    private fun toggleButton(button: Button, active: Boolean) {
        button.isEnabled = active
        button.isClickable = active
    }

    private fun enableButton(button: Button) {
        button.isEnabled = true
        button.isClickable = true
    }
}