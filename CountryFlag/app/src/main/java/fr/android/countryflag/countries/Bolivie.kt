package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.core.graphics.toColorInt
import fr.android.countryflag.countries.Country

@Composable
fun BolivieFlag() {
    Column(
        modifier= Modifier
            .fillMaxSize()
            .border(width= Dp.Hairline, color= Color.Black)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(color= Color("#DA291C".toColorInt()))
                .weight(1f/3f, fill=true)
        ) {}
        Row(
            Modifier
                .fillMaxWidth()
                .background(color= Color("#F4E400".toColorInt()))
                .weight(1f/3f, fill=true)
        ) {}
        Row(
            Modifier
            .fillMaxWidth()
                .background(color= Color("#007A33".toColorInt()))
            .weight(1f/3f, fill=true)
        ) {}
    }
}

object Bolivie: Country(
    "Bolivia",
    12_186_079, // millions
    1.098_581f, // milliards km²
    40.822f, // milliards $
    8.51f, // %
    10.799f, // milliards $
    11.439f, // milliards $
    { BolivieFlag() }
)