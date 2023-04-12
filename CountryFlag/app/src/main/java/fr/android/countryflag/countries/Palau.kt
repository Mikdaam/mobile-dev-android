package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

@Preview(name = "Preview1", device = Devices.PIXEL, showSystemUi = true)
@Composable
fun PalauFlag() {
    Row(modifier= Modifier
        .fillMaxSize()
        .border(width = Dp.Hairline, color = Color.Black)
        .background(color = Color(0xFF4AADD6))) {

        Box(
            Modifier
                .background(color = Color.Transparent)
                .weight(4f / 16f, fill = true)
                .fillMaxHeight()) {}
        Box(
            Modifier
                .background(color = Color(0xFFFFDE00), shape = CircleShape)
                .weight(10f / 16f, fill = true)
                .aspectRatio(1f)
                .align(Alignment.CenterVertically)
                .fillMaxHeight()) {}
        Box(
            Modifier
                .background(color = Color.Transparent)
                .weight(16f / 16f, fill = true)
                .fillMaxHeight()) {}
    }
}

object Palau: Country(
    "Palau",
    21500,
    465f,
    0.3f,
    1.8f,
    5.882f,
    5.31f,
    { PalauFlag() }
)