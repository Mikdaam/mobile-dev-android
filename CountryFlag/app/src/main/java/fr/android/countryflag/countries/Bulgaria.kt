package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.Country

@Composable
fun BulgariaFlag() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 3f, fill = true)
                .background(Color.White)) { }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 3f, fill = true)
                .background(Color(red = 0x00, green = 0x96, blue = 0x6E, alpha = 0xFF))) { }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 3f, fill = true)
                .background(Color(red = 0xD6, green = 0x26, blue = 0x12, alpha = 0xFF))) { }
    }
}

object Bulgaria: Country(
        "Bulgaria",
    6827736,
    110879f, //sq km
    167.804f, //billion
        5.42f, //%
        50.059f, //billion
        51.505f, //billion
        { BulgariaFlag() }
    )