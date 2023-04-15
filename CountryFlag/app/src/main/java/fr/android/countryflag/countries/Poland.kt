package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.android.countryflag.countries.Country

@Preview
@Composable
fun PolishFlag() {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .weight(1f / 2f, fill = true))
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .weight(1f / 2f, fill = true))
    }
}

object Poland: Country(
    name = "Poland",
    population =37_991_766,
    area = 312.685f,
    gdp = 1_318f,
    unemployment = 3.37f,
    imports = 380.699f,
    exports = 411.621f,
    flag = { PolishFlag() }
)
