package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country

@Composable
fun SwitzerlandFlag() {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .background(Color.Red)
            .border(width = Dp.Hairline, color = Color.Black)
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .width(60.dp)
                .height(200.dp)
                .align(Alignment.Center)
        ) {

        }
        Box(
            modifier = Modifier
                .background(Color.White)
                .width(200.dp)
                .height(60.dp)
                .align(Alignment.Center)
        ) {

        }
    }
}

object Switzerland : Country(
    name = "Switzerland",
    population = 8_563_760,
    area = 41_277f, // sq km
    gdp = 618.228f, // billion
    unemployment = 5.32f, // %
    imports = 480.522f, // billion
    exports = 571.376f, // billion
    flag = { SwitzerlandFlag() }
)

