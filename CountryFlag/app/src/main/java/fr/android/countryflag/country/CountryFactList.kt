package fr.android.countryflag.country

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.android.countryflag.countries.Country
import fr.android.countryflag.fact.Fact

@Composable
fun CountryFactList(countries: List<Country>, fact: Fact, highestFact: Country, navigate: (Boolean, Country) -> Unit) {
    LazyColumn {
        itemsIndexed(countries) {id, country ->
            CountryFactListItem(country = country, index = id + 1, fact, highestFact, navigate)
            //Divider()
        }
    }
}
