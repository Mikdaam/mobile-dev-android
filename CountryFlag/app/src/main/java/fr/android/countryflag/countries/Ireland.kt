package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

object Ireland: Country(
    "Ireland",
    5_011_500,
    70_273f,
    519f,
    5.9f,
    98.13f,
    219.7f,
    { IrelandFlag() }
)

@Composable
fun IrelandFlag() {
    Row(modifier= Modifier
        .fillMaxSize()
        .border(width = Dp.Hairline, color = Color.Black)) {
        Box(
            Modifier
                .fillMaxHeight()
                .background(color = Color(0xFF169B62))
                .weight(1f / 3f, fill = true))
        Box(
            Modifier
                .fillMaxHeight()
                .background(color = Color(0xFFFFFFFF))
                .weight(1f / 3f, fill = true))
        Box(
            Modifier
                .fillMaxHeight()
                .background(color = Color(0xFFFF883E))
                .weight(1f / 3f, fill = true))
    }
}