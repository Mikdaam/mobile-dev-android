package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

@Composable
fun BeninFlag() {
    Row(modifier= Modifier
        .fillMaxSize()
        .border(width = Dp.Hairline, color = Color.Black)) {
        Box(
            Modifier
                .fillMaxHeight()
                .background(color = Color(color = android.graphics.Color.parseColor("#00A651")))
                .weight(3f / 7f, fill = true)
        ) {}

        Column(
            Modifier
                .fillMaxHeight()
                .weight(2f / 3f, fill = true)
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color(color = android.graphics.Color.parseColor("#FFF200")))
                    .weight(1f / 2f, fill = true)
            ) {}
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color(color = android.graphics.Color.parseColor("#ED1C24")))
                    .weight(1f / 2f, fill = true)
            ) {}
        }
    }
}

object Benin: Country(
    name = "Benin",
    population = 14_219_908,
    area = 112_622f, // Square Kilometers
    gdp = 43.17f, // billion $
    unemployment = 1.57f, // percentage %
    imports = 3.942f, // billion $
    exports = 3.506f, // billion $
    flag = { BeninFlag() }
)