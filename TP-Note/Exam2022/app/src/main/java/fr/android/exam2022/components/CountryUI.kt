package fr.android.exam2022.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import fr.android.exam2022.Country

@Composable
fun CountryDisplayer(country: Country) {
    val (code, name, latitude, longitude) = country
    val flagImageName = code.lowercase().plus(".png")
    val context = LocalContext.current

    Box {
        Column {
            Image(
                bitmap = BitmapFactory.decodeStream(
                    context.assets.open("flags/$flagImageName")
                ).asImageBitmap(),
                contentDescription = "Flag of $name",
            )
            Text(text = name)
        }
    }
}

@Composable
fun CountriesDisplayer(countries: List<Country>, onCountryClicked: (Country) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        itemsIndexed(countries) { _, country ->
            CountryDisplayer(country)
        }
    }
}