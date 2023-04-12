package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.Country

@Composable
fun MonacoFlags() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 2f, fill = true)
                .background(Color.Red)) { }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 2f, fill = true)
                .background(Color.White)) { }
    }
}

object Monaco : Country(
    "Monaco",
    31597,
    2f,
    1.7f,
    2f,
    1.371f,
    0.964f,
    { MonacoFlags() }
)