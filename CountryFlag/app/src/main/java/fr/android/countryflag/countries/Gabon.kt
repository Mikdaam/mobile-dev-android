package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country

@Composable
fun GabonFlag(){
    Column(
        modifier = Modifier.size(width = 400.dp, height = 300.dp),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 3f, fill = true)
                .background(Color(red = 0, green = 158, blue = 96, alpha = 255))) { }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 3f, fill = true)
                .background(Color(red = 252, green = 209, blue = 22, alpha = 255))) { }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 3f, fill = true)
                .background(Color(red = 58, green = 117, blue = 196, alpha = 255))) { }
    }
}

object Gabon: Country(
    "Gabon",
    2397368,
    267667f,
    32.34f,
    22.26f,
    5.02f,
    10.8f,
    { GabonFlag() }
)