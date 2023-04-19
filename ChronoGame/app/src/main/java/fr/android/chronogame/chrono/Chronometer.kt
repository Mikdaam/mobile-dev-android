package fr.android.chronogame.chrono

import androidx.compose.runtime.*
import kotlinx.coroutines.delay

@Composable
fun Chronometer(startTime: Long, endTime: Long = -1, onTimeChanged: (Long) -> Unit) {
    var currentTime by remember { mutableStateOf(System.currentTimeMillis()) }

    LaunchedEffect(endTime) {
        if (endTime == -1L) {
            while(true) {
                currentTime = System.currentTimeMillis();
                onTimeChanged(currentTime)
                delay(100L)
            }
        }
    }

    val delta = if (endTime == -1L) currentTime - startTime else endTime - startTime

    DeltaTimeDisplayer(deltaTime = delta)
}