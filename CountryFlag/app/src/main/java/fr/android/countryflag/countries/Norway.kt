package fr.android.countryflag.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import fr.android.countryflag.countries.Country


@Composable
fun NorvegianFlag() {
    val myRedColor = Color(android.graphics.Color.parseColor("#BA0C2F"));
    val myBlueColor = Color(android.graphics.Color.parseColor("#00205B"));
    Box(modifier = Modifier
        .aspectRatio(ratio = 1.375F)
        .border(2.dp, androidx.compose.ui.graphics.Color.Black, shape = RectangleShape)){
        Column() {
            Row(
                Modifier.fillMaxSize().weight(6 / 16F, fill = true)) {
                Box(Modifier.fillMaxSize().weight(6 / 22F, fill = true).background(color = myRedColor))
                Box(Modifier.fillMaxSize().weight(1 / 22F, fill = true).background(color = androidx.compose.ui.graphics.Color.White))
                Box(Modifier.fillMaxSize().weight(2 / 22F, fill = true).background(color = myBlueColor))
                Box(Modifier.fillMaxSize().weight(1 / 22F, fill = true).background(color = androidx.compose.ui.graphics.Color.White))
                Box(Modifier.fillMaxSize().weight(12 / 22F, fill = true).background(color = myRedColor))
            }
            Row(
                Modifier.fillMaxSize().weight(1 / 16F, fill = true)) {
                Box(Modifier.fillMaxSize().weight(7 / 22F, fill = true).background(color = androidx.compose.ui.graphics.Color.White))
                Box(Modifier.fillMaxSize().weight(2 / 22F, fill = true).background(color = myBlueColor))
                Box(Modifier.fillMaxSize().weight(13 / 22F, fill = true).background(color = androidx.compose.ui.graphics.Color.White))
            }
            Row(
                Modifier.fillMaxSize().weight(2 / 16F, fill = true)) {
                Box(Modifier.fillMaxSize().weight(1F, fill = true).background(color = myBlueColor))
            }
            Row(
                Modifier.fillMaxSize().weight(1 / 16F, fill = true)) {
                Box(Modifier.fillMaxSize().weight(7 / 22F, fill = true).background(color = androidx.compose.ui.graphics.Color.White))
                Box(Modifier.fillMaxSize().weight(2 / 22F, fill = true).background(color = myBlueColor))
                Box(Modifier.fillMaxSize().weight(13 / 22F, fill = true).background(color = androidx.compose.ui.graphics.Color.White))
            }
            Row(
                Modifier.fillMaxSize().weight(6 / 16F, fill = true)) {
                Box(Modifier.fillMaxSize().weight(6 / 22F, fill = true).background(color = myRedColor))
                Box(Modifier.fillMaxSize().weight(1 / 22F, fill = true).background(color = androidx.compose.ui.graphics.Color.White))
                Box(Modifier.fillMaxSize().weight(2 / 22F, fill = true).background(color = myBlueColor))
                Box(Modifier.fillMaxSize().weight(1 / 22F, fill = true).background(color = androidx.compose.ui.graphics.Color.White))
                Box(Modifier.fillMaxSize().weight(12 / 22F, fill = true).background(color = myRedColor))
            }
        }
    }


}

object Norway: Country(
    "Norway",
    5597924,
    323802f,
    3.88f,
    4.99f,
    1.40443992E11f,
    1.99074005E11f,
    { NorvegianFlag() }
)