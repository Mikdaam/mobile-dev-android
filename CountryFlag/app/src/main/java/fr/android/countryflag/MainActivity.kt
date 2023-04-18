package fr.android.countryflag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.android.countryflag.countries.ALL_COUNTRIES
import fr.android.countryflag.countries.Benin
import fr.android.countryflag.country.CountryFactList
import fr.android.countryflag.country.CountryMultiFactDisplayer
import fr.android.countryflag.fact.Fact
import fr.android.countryflag.ui.theme.CountryFlagTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryFlagTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RootUI()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryFlagTheme {
        RootUI()
    }
}