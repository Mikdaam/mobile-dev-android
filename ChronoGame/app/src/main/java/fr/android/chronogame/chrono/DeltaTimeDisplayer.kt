package fr.android.chronogame.chrono

import android.text.format.DateUtils
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeltaTimeDisplayer(deltaTime: Long) {
    val formatted = DateUtils.formatElapsedTime(deltaTime / 1000) // format HH:MM
    Text(
        "$formatted:${String.format("%03d", deltaTime % 1000)}",
        Modifier.padding(10.dp),
        textAlign = TextAlign.Center,
        fontSize = 25.sp
    )
}