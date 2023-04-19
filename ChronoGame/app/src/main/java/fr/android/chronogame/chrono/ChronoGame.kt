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
import androidx.compose.ui.unit.sp

@Composable
fun ChronoGame(expectedDuration: Long, onVerdict: (Long) -> Unit) {
    var start by remember { mutableStateOf(System.currentTimeMillis()) }
    var end by remember { mutableStateOf(System.currentTimeMillis()) }
    var elapsedTime by remember { mutableStateOf(0L) }
    var isStopped by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        Box(
            modifier = Modifier.size(250.dp)
                .background(Color(0xFF238386))
                .clip(shape = RoundedCornerShape(15.dp))
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Chronometer(startTime = start, endTime = end, onTimeChanged = { elapsedTime = it - start })
            if (elapsedTime >= expectedDuration / 2) {
                Card(
                    Modifier
                        .background(color = Color.Blue, shape = RoundedCornerShape(5.dp)),
                ) {
                    Text(
                        text = "GigaChad",
                        fontSize = 30.sp
                    )
                }
            }
        }

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
                    onVerdict(end - start)
                },
                Modifier.clip(RoundedCornerShape(10.dp)),
                enabled = isStopped
            ) {
                Text(text = "Stop")
            }
        }
    }
}