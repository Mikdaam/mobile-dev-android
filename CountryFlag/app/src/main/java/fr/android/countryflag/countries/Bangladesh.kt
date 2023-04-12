package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country


@Composable
fun BangladeshFlag() {
    Box(modifier = Modifier.fillMaxSize().background(Color(0xff006a4e)).wrapContentSize(
        Alignment.Center)){
        Box(
            modifier = Modifier.fillMaxWidth(0.4f).aspectRatio(1f).absoluteOffset(x = (-5).dp).clip(CircleShape).background(Color(0xfff42a41))
        )
    }

}

object Bangladesh: Country(
    "Bangladesh",
    167_184_465,
    148_460f, // km²
    2.6f, // %
    14.7f, // %
    85.303f, // billions
    49.386f, // billions
    { BangladeshFlag() }
)