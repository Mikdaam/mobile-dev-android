package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

object Italy : Country(
    "Italia",
    61021855,//population
    301340f,// sq km
    2.478f,// gdp trillion $
    9.83f,// unemployment %
    637.934f,//imports billion$
    687.948f,// exports billion $
    { ItalieFlag() }
)

    @Preview(showBackground = true)
    @Composable
    fun ItalieFlag(){
        Row( modifier = Modifier
            .fillMaxSize()
            .border(Dp.Hairline, color = Color.Black)){
            Box(Modifier
                .fillMaxHeight()
                .background(color = Color(0,140,69))
                .weight(1f/3f, fill = true)){}
            Box(Modifier
                .fillMaxHeight()
                .background(color = Color(244, 245, 240))
                .weight(1f/3f, fill = true)){}
            Box(Modifier
                .fillMaxHeight()
                .background(color = Color(205, 33, 42))
                .weight(1f/3f, fill = true)){}
        }
    }


