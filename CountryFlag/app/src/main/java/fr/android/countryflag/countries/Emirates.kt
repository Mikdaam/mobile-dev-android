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
fun EmirateFlag() {
    Row(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Red)) {
        Box(
            Modifier
                .fillMaxHeight()
                .weight(1F / 4F, fill = true))
        Column(
            Modifier
                .fillMaxHeight()
                .weight(3F / 4F, fill = true)
                .background(color = Color.White)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1F / 3F, fill = true)
                    .background(color = Color(0, 115, 47)))
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1F / 3F, fill = true))
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1F / 3F, fill = true)
                    .background(color = Color.Black))
        }
    }
}

object UnitedArabEmirates : Country(
    "Emirats Arabes Unis",
    9992083, //hab
    82880f, //km²
    501.354f, // milliards de $
    3.9f, // %
    423.635f, // Millions de $
    526.998f, // Millions de $
    { EmirateFlag() }
)