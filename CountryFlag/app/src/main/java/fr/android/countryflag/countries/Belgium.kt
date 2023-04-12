package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.Country

@Composable
fun BelgiumFlag() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .weight(1f / 3f, fill = true)
                .background(Color.Black)) { }
        Column(
            Modifier
                .fillMaxHeight()
                .weight(1f / 3f, fill = true)
                .background(Color(red = 255, green = 233, blue = 54, alpha = 255))) { }
        Column(
            Modifier
                .fillMaxHeight()
                .weight(1f / 3f, fill = true)
                .background(Color(red = 255, green = 15, blue = 33, alpha = 255))) { }
    }
}

object Belgium : Country(
    "Belgium",
    11913633,
    57f,
    11.1f,
    6.42f,
    509.018f,
    515.625f,
    {BelgiumFlag()}
)