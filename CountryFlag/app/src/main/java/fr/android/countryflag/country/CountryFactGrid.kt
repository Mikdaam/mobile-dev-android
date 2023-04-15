package fr.android.countryflag.country

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.ALL_COUNTRIES
import fr.android.countryflag.countries.Country
import fr.android.countryflag.fact.Fact

@Composable
fun CountryFactGrid(countries: List<Country>, fact: Fact) {
    val sortedCountry = countries.sortedByDescending { fact.extractor(it) }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp)
    ) {
        itemsIndexed(sortedCountry) { index, country ->
            CountryFactGridItem(country = country, index = index + 1)
        }
    }
}
