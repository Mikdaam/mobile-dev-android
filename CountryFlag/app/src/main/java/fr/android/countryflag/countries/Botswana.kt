package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import fr.android.countryflag.countries.Country

object BotswanaFlag : Country(
    "Botswana",
    2417596,//population
    581730f,//area sq km
    3.8415001E13f,// gdp billion $
    24.72f,// unemployment %
    9.277f,//imports billion $
    7.931f,// exports billion $
    { BotswanaFlag()}
)
    @Preview(showBackground = true)
    @Composable
    fun BotswanaFlag(){
        Column(modifier = Modifier
            .fillMaxSize()
            .border(Dp.Hairline, color = Color.Black)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color(109, 169, 210))
                    .weight(9f / 14f, fill = true)){}
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color(255, 255, 255))
                    .weight(1f / 14f, fill = true)){}
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color(0, 0, 0))
                    .weight(2f / 7f, fill = true)){}
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color(255, 255, 255))
                    .weight(1f / 14f, fill = true)){}
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color(109, 169, 210))
                    .weight(9f / 14f, fill = true)){}
        }
    }
