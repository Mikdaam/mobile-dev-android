package fr.android.countryflag.country

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.android.countryflag.countries.Country
import fr.android.countryflag.fact.Fact
import fr.android.countryflag.ui.theme.QuickSand
import fr.android.countryflag.ui.theme.QuickSandBold

@Composable
fun CountryFactGridItem(country: Country, index: Int, fact: Fact) {
    Box(Modifier
        .height(150.dp)
        .padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#$index ${country.name}",
                color = Color(0xFF454545),
                fontSize = 12.sp,
                fontFamily = QuickSandBold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f)
            ) {
                country.flag.invoke()
            }
            Text(
                text ="${fact.extractor(country)} ${fact.unit}",
                color = Color(0xFF454545),
                fontSize = 12.sp,
                fontFamily = QuickSand,
                textAlign = TextAlign.Center
            )
        }
    }
}
