package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.Country

@Composable
fun RussiaFlag() {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFFFFF))
                .weight(1f / 3f, fill = true)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0039A6))
                .weight(1f / 3f, fill = true)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD52B1E))
                .weight(1f / 3f, fill = true)
        )
    }
}

object Russia: Country(
    "Russia",
    141698923,
    17098242f,
    4078f,
    5.01f,
    379.947f,
    550.035f,
    { RussiaFlag() }
)
