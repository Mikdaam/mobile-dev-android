package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country

object Niger: Country(
    "Niger",
    22_772_361,
    1_267_000f,
    13.68f,
    2.6f,
    2.194f,
    1.177f,
    { NigerFlag() }
)

@Composable
fun NigerFlag() {
    Box(modifier=Modifier.fillMaxWidth().border(width=Dp.Hairline, color=Color.Black).background(color=Color.White)) {
        Column(Modifier.fillMaxSize()) {
            Box(
                Modifier.fillMaxWidth()
                    .weight(1f/2f, fill = true)
                    .background(color = Color(0xFFFFB25B))
            )
            Box(
                Modifier.fillMaxWidth()
                    .weight(1f/2f, fill = true)
                    .background(color = Color.White)
            ) {
                Box (
                    modifier = Modifier
                        .size(80.dp)
                        .background(color = Color(0xFFFFB25B), shape = CircleShape)
                        .scale(0.5f)
                        .align(Alignment.Center)
                )
            }
            Box(Modifier.fillMaxWidth().weight(1f/2f, fill=true).background(color=Color(0xFF009639)))
        }
    }
}