package fr.android.countryflag.country

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.android.countryflag.countries.Country
import fr.android.countryflag.ui.theme.QuickSand
import fr.android.countryflag.ui.theme.QuickSandBold

@Composable
fun CountryFactGridItem(country: Country, index: Int) {
    Box(Modifier.height(100.dp)) {
        Column {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "#$index",
                    color = Color(0xFF454545),
                    fontSize = 16.sp,
                    fontFamily = QuickSandBold,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = country.name,
                    color = Color(0xFF454545),
                    fontSize = 20.sp,
                    fontFamily = QuickSand
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f)
            ) {
                country.flag.invoke()
            }
            Text(
                text = "${country.population} people",
                color = Color(0xFF454545),
                fontSize = 20.sp,
                fontFamily = QuickSand,
            )
        }
    }
}
