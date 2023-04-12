package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.android.countryflag.countries.Country

@Preview(showBackground = true)
@Composable
fun NigeriaFlag() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .weight(1f / 3f, fill = true)
                .background(Color(red = 0x00, green = 0x87, blue = 0x53, alpha = 0xFF))) { }
        Column(
            Modifier
                .fillMaxHeight()
                .weight(1f / 3f, fill = true)
                .background(Color.White)) { }
        Column(
            Modifier
                .fillMaxHeight()
                .weight(1f / 3f, fill = true)
                .background(Color(red = 0x00, green = 0x87, blue = 0x53, alpha = 0xFF))) { }
    }
}

object Nigeria: Country(
        "Nigeria",
        230842743,
        923768f, //sq km
        1.05f, //trillion
        9.79f, //%
        66.107f, //billion
        50.856f, //billion
        { NigeriaFlag() }
    )