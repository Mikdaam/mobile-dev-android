package fr.android.countryflag.country

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.ALL_COUNTRIES
import fr.android.countryflag.fact.Fact

@Composable
fun CountryMultiFactDisplayer() {
    Column {
        var currentFact by remember { mutableStateOf(Fact.POPULATION) }
        var countries by remember { mutableStateOf(ALL_COUNTRIES) }
        var listView by remember { mutableStateOf(true) }

        Header(
            fact = currentFact,
            onChange = { currentFact = it },
            countries = countries,
            onSort = { countries = it },
            listView,
            onChangeView = { listView = it }
        )
        Box(Modifier.background(color = Color(0xFFF8F7F7))) {
            if (listView) {
                CountryFactList(countries, currentFact)
            } else {
                CountryFactGrid(countries, currentFact)
            }
        }
    }
}