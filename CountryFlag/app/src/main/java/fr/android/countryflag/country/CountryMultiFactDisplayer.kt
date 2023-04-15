package fr.android.countryflag.country

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import fr.android.countryflag.countries.ALL_COUNTRIES
import fr.android.countryflag.fact.Fact

@Composable
fun CountryMultiFactDisplayer() {
    Column {
        var currentFact by remember { mutableStateOf(Fact.POPULATION) }
        var countries by remember { mutableStateOf(ALL_COUNTRIES) }
        Header(
            fact = currentFact,
            onChange = { currentFact = it },
            countries = countries,
            onSort = { countries = it.reversed() }
        )
        //CountryFactList(countries, currentFact)
        CountryFactGrid(countries, currentFact)
    }
}