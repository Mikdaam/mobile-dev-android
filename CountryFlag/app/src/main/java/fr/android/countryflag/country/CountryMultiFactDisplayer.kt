package fr.android.countryflag.country

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.ALL_COUNTRIES
import fr.android.countryflag.countries.Country
import fr.android.countryflag.fact.Fact

@Composable
fun CountryMultiFactDisplayer(navigate: (Boolean, Country) -> Unit) {
    Column {
        var currentFact by remember { mutableStateOf(Fact.POPULATION) }
        var countries by remember { mutableStateOf(ALL_COUNTRIES.sortedByDescending { currentFact.extractor(it) }) }
        var listView by remember { mutableStateOf(true) }
        var descendingSort by remember { mutableStateOf(true) }

        Header(
            fact = currentFact,
            onChange = { currentFact = it },
            countries = countries,
            onSort = { countries = it },
            listView,
            onChangeView = { listView = it },
            descendingSort,
            changeOrder = { descendingSort = it }
        )
        Box(Modifier.background(color = Color(0xFFF8F7F7))) {
            val high = remember { derivedStateOf { countries.first() } }
            if (listView) {
                CountryFactList(countries, currentFact, high.value, navigate)
            } else {
                CountryFactGrid(countries, currentFact, navigate)
            }
        }
    }
}