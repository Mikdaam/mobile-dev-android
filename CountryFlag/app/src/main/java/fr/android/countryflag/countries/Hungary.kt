package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country

@Composable
fun HungaryFlag() {
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier=Modifier.fillMaxSize()) {
            Box(
                modifier=Modifier.height(70.dp).clip(RectangleShape).background(Color(0xFFCE2939)).fillMaxSize().weight(1f / 3f, true)
            )
            Box(
                modifier=Modifier.height(70.dp).clip(RectangleShape).background(Color.White).fillMaxSize().weight(1f / 3f, true)
            )
            Box(
                modifier=Modifier.height(70.dp).clip(RectangleShape).background(Color(0xFF477050)).fillMaxSize().weight(1f / 3f, true)
            )
        }
    }
}

object Hungary: Country(
    "Hungary",
    9_670_009,
    93_028f, // km²
    7.3f, // %
    13.5f, // %
    147.577f, // billions
    148.229f, // billions
    { HungaryFlag() }
)