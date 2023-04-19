package fr.android.chronogame.chrono

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ChronometerManager() {
    var start by remember { mutableStateOf(System.currentTimeMillis()) }
    var end by remember { mutableStateOf(System.currentTimeMillis()) }
    var isStopped by remember { mutableStateOf(false) }

    Column(
        Modifier
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        Chronometer(startTime = start, endTime = end, onTimeChanged = {})

        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    start = System.currentTimeMillis()
                    end = -1L
                    isStopped = !isStopped
                },
                Modifier.clip(RoundedCornerShape(10.dp)),
                enabled = !isStopped
            ) {
                Text(text = "Start")
            }

            Button(
                onClick = {
                    end = System.currentTimeMillis()
                    isStopped = !isStopped
                },
                Modifier.clip(RoundedCornerShape(10.dp)),
                enabled = isStopped
            ) {
                Text(text = "Stop")
            }
        }
    }
}