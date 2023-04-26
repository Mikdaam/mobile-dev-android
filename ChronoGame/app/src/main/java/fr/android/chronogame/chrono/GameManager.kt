package fr.android.chronogame.chrono

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

enum class State {
    ONE, TWO, THREE
}

@Composable
fun GameManager() {
    var gameState by remember { mutableStateOf(State.ONE) }
    var expectedDuration by remember { mutableStateOf(2_000) }

    Column(
        Modifier.fillMaxSize()
    ) {
        Slider(value = 2f, onValueChange = { expectedDuration = it.toInt() })
    }
}