package fr.android.countryflag

import androidx.compose.runtime.*
import fr.android.countryflag.countries.Benin
import fr.android.countryflag.countries.Country
import fr.android.countryflag.country.CountryDisplayer
import fr.android.countryflag.country.CountryMultiFactDisplayer

@Composable
fun RootUI() {
    var detailed by remember { mutableStateOf(false) }
    var detailedCountry by remember { mutableStateOf<Country>(Benin) }

    if (detailed) {
        CountryDisplayer(country = detailedCountry, navigate = {detailed = it})
    } else {
        CountryMultiFactDisplayer(navigate = { detail, country -> detailed = detail; detailedCountry = country })
    }
}