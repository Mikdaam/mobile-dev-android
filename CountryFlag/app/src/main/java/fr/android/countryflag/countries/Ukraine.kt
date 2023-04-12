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
fun UkrainianFlag() {
    val blue = Color(0, 87, 183)
    val yellow = Color(255, 215, 0)
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(blue)
                .weight(1f / 2f, fill = true)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .background(yellow)
                .weight(1f / 2f, fill = true)
        )
    }
}

object Ukraine: Country(
    name = "Ukraine",
    population = 43_306_477,
    area = 603.550f,
    gdp = 535.579f,
    unemployment = 8.88f, //Not found
    imports = 84.175f,
    exports = 81.504f,
    flag = { UkrainianFlag() }
)