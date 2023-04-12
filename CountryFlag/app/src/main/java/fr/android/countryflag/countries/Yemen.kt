package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.core.graphics.toColorInt
import fr.android.countryflag.countries.Country

@Composable
fun YemenFlag() {
    Column(
        modifier= Modifier
            .fillMaxSize()
            .border(width= Dp.Hairline, color= Color.Black)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(color=Color("#CE1126".toColorInt()))
                .weight(1f/3f, fill=true)
        ) {}
        Row(
            Modifier
                .fillMaxWidth()
                .background(color=Color.White)
                .weight(1f/3f, fill=true)
        ) {}
        Row(Modifier
            .fillMaxWidth()
            .background(color=Color.Black)
            .weight(1f/3f, fill=true)
        ) {}
    }
}

object Yemen: Country(
    "Yemen",
    31_565_602, // millions
    527.968f, // km²
    54.356f, // milliards $
    13.57f, // %
    4.079f, // milliards $
    384.5f, // millions $
    { YemenFlag() }
)
