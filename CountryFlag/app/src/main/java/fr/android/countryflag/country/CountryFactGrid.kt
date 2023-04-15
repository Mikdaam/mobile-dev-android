package fr.android.countryflag.country

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import fr.android.countryflag.countries.ALL_COUNTRIES

@Composable
fun CountryFactGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        itemsIndexed(ALL_COUNTRIES) { index, country ->
            CountryFactGridItem(country = country, index = index)
        }
    }
}
