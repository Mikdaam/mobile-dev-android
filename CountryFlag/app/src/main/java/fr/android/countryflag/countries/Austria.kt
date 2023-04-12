package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun AustriaFlag() {
    Column(modifier=Modifier.fillMaxSize().border(width= Dp.Hairline, color=Color.Black)) {
        Box(Modifier.fillMaxWidth().background(color=Color(0xFFC9072A)).weight(1f/3f, fill=true)) {}
        Box(Modifier.fillMaxWidth().background(color=Color.White).weight(1f/3f, fill=true)) {}
        Box(Modifier.fillMaxWidth().background(color=Color(0xFFC9072A)).weight(1f/3f, fill=true)) {}
    }
}

object Austria: Country(
    "Austria",
    8859449,
    83871f,
    479.820f,
    6.2f,
    219.520f,
    202.806f,
    { AustriaFlag() }
)