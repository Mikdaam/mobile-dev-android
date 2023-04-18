package fr.android.countryflag.country

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.android.countryflag.countries.Country
import fr.android.countryflag.fact.Fact
import fr.android.countryflag.fact.ui.FactBar
import fr.android.countryflag.ui.theme.QuickSand
import fr.android.countryflag.ui.theme.QuickSandBold

@Composable
fun CountryFactListItem(country: Country, index: Int, fact: Fact, highest: Country, navigate: (Boolean, Country) -> Unit) {
    val ratio = fact.extractor(country) / fact.extractor(highest);
    val text = "${fact.extractor(country)} ${fact.unit}"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .height(80.dp)
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF718BE7),
                        Color(0xFF71B6EB)
                    )
                ),
                shape = RoundedCornerShape(5.dp),
            )
            .clickable { navigate.invoke(true, country) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .weight(1/10f)
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "#$index",
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = QuickSandBold,
                fontStyle = FontStyle.Italic
            )
        }
        Box(modifier = Modifier
            .weight(3/10f)
        ) {
            country.flag.invoke()
        }
        Box(
            Modifier
                .width(IntrinsicSize.Max)
                .padding(5.dp)
                .weight(3/10f),
        ) {
            Text(
                text = country.name,
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = QuickSand,
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = Modifier
                .weight(4/10f)
                .height(20.dp)
        ) {
            FactBar(ratio, text)
        }
    }
}
