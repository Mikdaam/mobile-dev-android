package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

@Composable
fun IndonesiaFlag() {
    Column(modifier=Modifier.fillMaxSize().border(width= Dp.Hairline, color=Color.Black)) {
        Box(Modifier.fillMaxWidth().background(color=Color(0xFFFF0000)).weight(1f/2f, fill=true)) {}
        Box(Modifier.fillMaxWidth().background(color=Color.White).weight(1f/2f, fill=true)) {}
    }
}

object Indonesia: Country(
    "Indonesia",
    270203917,
    1904569f,
    4374000f,
    6.2f,
    196.041f,
    229.850f,
    { IndonesiaFlag() }
)