package fr.android.countryflag.country

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.android.countryflag.countries.Country
import fr.android.countryflag.ui.theme.QuickSand

@Composable
private fun FactRow(FactName: String, FactValue: String) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = FactName,
            fontSize = 20.sp,
            color = Color.White,
            fontFamily = QuickSand,
            textAlign = TextAlign.Center
        )
        Text(
            text = FactValue,
            fontSize = 20.sp,
            color = Color.White,
            fontFamily = QuickSand,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun CountryDisplayer(country: Country, navigate: (Boolean) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = country.name)
                },
                navigationIcon = {
                    IconButton(onClick = { navigate.invoke(false) }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(0xFF718BE7),
                            Color(0xFF71B6EB)
                        )
                    )
                )
                .padding(25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = country.name,
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = QuickSand,
                textAlign = TextAlign.Center
            )
            Box(modifier = Modifier
                .padding(10.dp)
                .width(150.dp)
                .height(100.dp)
            ) {
                country.flag.invoke()
            }

            Column(
                Modifier
                    .background(Color(0xFF32506B), shape = RoundedCornerShape(5.dp))
                    .padding(5.dp)
            ) {
                FactRow(FactName = "Population", FactValue = "${country.population}")
                Divider()
                FactRow(FactName = "Area", FactValue = "${country.area}")
                Divider()
                FactRow(FactName = "GDP", FactValue = "${country.gdp}")
                Divider()
                FactRow(FactName = "Unemployment", FactValue = "${country.unemployment}")
                Divider()
                FactRow(FactName = "Imports", FactValue = "${country.imports}")
                Divider()
                FactRow(FactName = "Exports", FactValue = "${country.exports}")
            }
        }
    }
}