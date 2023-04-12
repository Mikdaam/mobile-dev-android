package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country

@Composable
fun MauritiusFlag() {
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
                    .background(color = Color(0xFFEB2436))
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = true)
                    .background(color = Color(0xFF131A6D))
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = true)
                    .background(color = Color(0xFFFFD600))
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = true)
                    .background(color = Color(0xFF00A650))
            )
        }
    }
}


object Mauritius : Country(
    name = "Mauritius",
    population = 1_309_448,
    area = 2_040f, // sq km
    gdp = 26.547f, // billion
    unemployment = 7.41f, // %
    imports = 6.082f, // billion
    exports = 3.198f, // billion
    flag = { MauritiusFlag() }
)