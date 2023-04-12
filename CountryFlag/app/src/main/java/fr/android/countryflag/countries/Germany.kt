package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country


@Composable
fun GermanFlag() {
    Box(modifier = Modifier.aspectRatio(ratio = 1.667F).border(2.dp, Color.Black, shape = RectangleShape)){
        Column() {
            Box(Modifier.fillMaxWidth().weight(1f / 3f, fill = true).background(color = Color.Black))
            Box(Modifier.fillMaxWidth().weight(1f / 3f, fill = true).background(color = Color.Yellow))
            Box(Modifier.fillMaxWidth().weight(1f / 3f, fill = true).background(color = Color.Red))
        }
    }
}

object Germany: Country(
    "Germany",
    84220184,
    357022f,
    2.63f,
    3.54f,
    1771f,
    2004f,
    { GermanFlag() }
)