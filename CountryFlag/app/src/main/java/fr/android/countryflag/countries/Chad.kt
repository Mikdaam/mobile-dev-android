package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

object Chad: Country(
    "Chad",
    17_963_211,
    1_284_000f,
    32.062f,
    1.88f,
    2.262f,
    1.695f,
    { ChadFlag() }
)

@Composable
fun ChadFlag() {
    Row(modifier=Modifier.fillMaxSize().border(width=Dp.Hairline, color=Color.Black)) {
        Box(Modifier.fillMaxHeight().background(color=Color(0xFF002664)).weight(1f/3f, fill=true))
        Box(Modifier.fillMaxHeight().background(color=Color(0xFFFECB00)).weight(1f/3f, fill=true))
        Box(Modifier.fillMaxHeight().background(color=Color(0xFFC60C30)).weight(1f/3f, fill=true))
    }
}