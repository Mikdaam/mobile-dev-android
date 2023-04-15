package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.android.countryflag.countries.Country

@Preview
@Composable
fun IcelandicFlag() {
    val blue = Color(2, 82, 156)
    val red = Color(220, 30, 53)
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(7f / 18f, fill = true)) {
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(7f / 25f, fill = true)
                    .background(blue))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f / 25f, fill = true)
                    .background(Color.White))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(2f / 25f, fill = true)
                    .background(red))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f / 25f, fill = true)
                    .background(Color.White))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(14f / 25f, fill = true)
                    .background(blue))
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 18f, fill = true)) {
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(8f / 25f, fill = true)
                    .background(Color.White))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(2f / 25f, fill = true)
                    .background(red))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(15f / 25f, fill = true)
                    .background(Color.White))
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(2f / 18f, fill = true)
                .background(red)) {}
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f / 18f, fill = true)) {
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(8f / 25f, fill = true)
                    .background(Color.White))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(2f / 25f, fill = true)
                    .background(red))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(15f / 25f, fill = true)
                    .background(Color.White))
        }
        Row(
            Modifier
                .fillMaxSize()
                .weight(7f / 18f, fill = true)
                .background(Color(2, 82, 156))) {
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(7f / 25f, fill = true))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f / 25f, fill = true)
                    .background(Color.White))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(2f / 25f, fill = true)
                    .background(red))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f / 25f, fill = true)
                    .background(Color.White))
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(14f / 25f, fill = true)
                    .background(blue))
        }
    }
}

object Iceland: Country(
    name = "Iceland",
    population = 360_872,
    area = 103_000f,
    gdp = 19.962f,
    unemployment = 5.4f,
    imports = 10.234f,
    exports = 9.775f,
    flag = { IcelandicFlag() }
)