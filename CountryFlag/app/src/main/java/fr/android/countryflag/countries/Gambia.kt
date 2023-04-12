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
fun GambiaFlag(){
    Column(
        modifier = Modifier.size(width = 399.dp, height = 266.dp),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 3f, fill = true)
                .background(Color.Red)) { }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 18f, fill = true)
                .background(Color.White)) {
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(2f / 9f, fill = true)
                .background(Color.Blue)) {
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 18f, fill = true)
                .background(Color.White)) {
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 3f, fill = true)
                .background(Color.Green)) { }
    }
}

object Gambia: Country(
    "Gambia",
    2468569,
    11300f,
    5.482f,
    11.21f,
    0.726f,
    0.135448f,
    { GambiaFlag() }
)