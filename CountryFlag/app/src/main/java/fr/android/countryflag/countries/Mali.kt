package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import fr.android.countryflag.countries.Country

@Composable
fun MaliFlag() {
    Box(modifier = Modifier.fillMaxSize()){
        Row(modifier=Modifier.fillMaxSize()) {
            Box(
                modifier=Modifier.fillMaxSize().clip(RectangleShape).background(Color(0xFF14B53A)).weight(1f / 3f, true)
            )
            Box(
                modifier=Modifier.fillMaxSize().clip(RectangleShape).background(Color(0xFFFCD116)).weight(1f / 3f, true)
            )
            Box(
                modifier=Modifier.fillMaxSize().clip(RectangleShape).background(Color(0xFFCE1126)).weight(1f / 3f, true)
            )
        }
    }
}

object Mali: Country(
    "Mali",
    21_359_722,
    1_240_192f, // km²
    2.02f, // %
    17.3f, // %
    6.339f, // billions
    5.196f, // billions
    { MaliFlag() }
)