package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.Country

@Composable
fun DenmarkFlag() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxHeight()
                .weight(4.5f / 10f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f / 10f, fill = true)
                    .background(Color.Red)) {}
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f / 10f, fill = true)
                    .background(Color.White)
            ) {}
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(5f / 10f, fill = true)
                    .background(Color.Red)
            ) {}
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .weight(1f / 10f)
                .background(Color.White)
        ) {}
        Row(
            modifier = Modifier.fillMaxWidth()
                .weight(4.5f / 10f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f / 10f, fill = true)
                    .background(Color.Red)) {}
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f / 10f, fill = true)
                    .background(Color.White)
            ) {}
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(5f / 10f, fill = true)
                    .background(Color.Red)
            ) {}
        }
    }
}

object Denmark : Country(
    "Denmark",
    5946984,
    43.094f,
    10.5f,
    4.9f,
    208.121f,
    234.262f,
    { DenmarkFlag() }
)