package fr.android.countryflag.country

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import fr.android.countryflag.fact.ui.FactBar
import fr.android.countryflag.ui.theme.QuickSand

@Composable
fun CountryFactListItem(country: Country, index: Int, fact: Fact, highest: Country) {
    val ratio = fact.extractor(country) / fact.extractor(highest);
    val text = "${fact.extractor(country)} ${fact.unit}"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(5.dp)
            .background(color = Color(0x68DAF5FF), shape = RoundedCornerShape(5.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .weight(1/10f)
                .padding(2.dp)
        ) {
            Text(
                text = "#$index",
                color = Color(0xFF454545),
                fontSize = 12.sp,
                fontFamily = QuickSand,
                fontStyle = FontStyle.Italic
            )
        }
        Box(modifier = Modifier
            .width(80.dp)
            .height(40.dp)
            .weight(3/10f)
        ) {
            country.flag.invoke()
        }
        Box(
            Modifier
                .width(IntrinsicSize.Max)
                .weight(3/10f),
        ) {
            Text(
                text = country.name,
                color = Color(0xFF454545),
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
