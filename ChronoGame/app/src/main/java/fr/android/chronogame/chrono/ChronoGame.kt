package fr.android.chronogame.chrono

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChronoGame(expectedDuration: Long, onVerdict: (Long) -> Unit) {
    var start by remember { mutableStateOf(0L) }
    var end by remember { mutableStateOf(0L) }
    var elapsedTime by remember { mutableStateOf(0L) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        Box(modifier = Modifier.size(150.dp)) {
            Chronometer(startTime = start, onTimeChanged = { elapsedTime = it - start })
            if (elapsedTime >= expectedDuration / 2) {
                Card(
                    Modifier
                        .background(color = Color.Blue, shape = RoundedCornerShape(5.dp)),
                ) {
                    Text(text = "GigaChad")
                }
            }
        }

        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { start = System.currentTimeMillis() },
                Modifier.clip(RoundedCornerShape(10.dp))
            ) {
                Text(text = "Start")
            }

            Button(
                onClick = {
                    end = System.currentTimeMillis()
                    onVerdict.invoke(end - start)
                },
                Modifier.clip(RoundedCornerShape(10.dp))
            ) {
                Text(text = "Stop")
            }
        }
    }
}