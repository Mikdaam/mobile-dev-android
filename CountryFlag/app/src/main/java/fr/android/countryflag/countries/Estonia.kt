package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.Country

@Composable
fun EstoniaFlag() {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0072ce))
                .weight(1f / 3f, fill = true)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF000000))
                .weight(1f / 3f, fill = true)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFFFFF))
                .weight(1f / 3f, fill = true)
        )
    }
}

object Estonia: Country(
    "Estonia",
    1202762,
    45228f,
    51.531f,
    5.40f,
    29.234f,
    29.056f,
    { EstoniaFlag() }
)
