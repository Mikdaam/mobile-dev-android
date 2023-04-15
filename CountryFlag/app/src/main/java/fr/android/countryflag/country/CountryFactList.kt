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
fun CountryFactList(countries: List<Country>, fact: Fact) {
    val sortedCountry = countries.sortedByDescending { fact.extractor(it) }
    val high = sortedCountry[0]
    Box(Modifier.background(color = Color(0xFFF8F7F7))) {
        LazyColumn {
            itemsIndexed(sortedCountry) {id, country ->
                CountryFactListItem(country = country, index = id + 1, fact, high)
                //Divider()
            }
        }
    }
}