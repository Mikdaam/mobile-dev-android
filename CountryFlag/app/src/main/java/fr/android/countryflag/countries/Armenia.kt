package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ArmeniaFlag() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .border(width = Dp.Hairline, color = Color.Black)
    ) {
        Column(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = true)
                    .background(color = Color(0xFFD90012))
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = true)
                    .background(color = Color(0xFF0033A0))
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = true)
                    .background(color = Color(0xFFF2A800))
            )
        }
    }
}


object Armenia : Country(
    name = "Armenia",
    population = 2_989_091,
    area = 29_743f, // sq km
    gdp = 39.6139f, // billion
    unemployment = 20.9f, // %
    imports = 6.12f, // billion
    exports = 5.012f, // billion
    flag = { ArmeniaFlag() }
)